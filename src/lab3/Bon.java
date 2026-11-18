package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bon {

    private static int urmatorulNumar = 1;

    private final int numar;
    private final Comanda comanda;

    public Bon(Comanda comanda) {
        if (comanda == null) {
            throw new IllegalArgumentException(
                    "Comanda nu poate fi null."
            );
        }

        this.numar = urmatorulNumar++;
        this.comanda = comanda;
    }

    public int getNumar() {
        return numar;
    }

    public BigDecimal reducereRegulaStandului() {

        int numarWaffle = comanda.cantitateDinClasa(Waffle.class);

        if (numarWaffle >= 2) {

            BigDecimal pretReducere = null;

            for (LinieComanda linie : comanda.getLinii()) {

                if (linie.getProdus() instanceof Waffle) {

                    if (pretReducere == null) {
                        pretReducere = BigDecimal.valueOf(
                                linie.getProdus().pretFinal()
                        );
                    } else {
                        pretReducere = BigDecimal.valueOf(
                                linie.getProdus().pretFinal()
                        );
                        break;
                    }
                }
            }

            if (pretReducere != null) {
                return pretReducere
                        .multiply(BigDecimal.valueOf(0.25))
                        .setScale(2, RoundingMode.HALF_UP);
            }
        }

        return BigDecimal.ZERO.setScale(2);
    }

    public BigDecimal totalDupaRegula() {

        return comanda.total()
                .subtract(reducereRegulaStandului())
                .max(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public boolean areCadou() {
        return numar % 4 == 0;
    }

    public String cadou() {
        if (areCadou()) {
            return "Topping gratuit la alegere";
        }

        return "Fara cadou";
    }

    public void afiseaza() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("        BON NR. " + numar);
        System.out.println("==============================");

        for (LinieComanda linie : comanda.getLinii()) {
            System.out.println(linie);
        }

        BigDecimal subtotal = comanda.total();
        BigDecimal reducere = reducereRegulaStandului();
        BigDecimal total = totalDupaRegula();

        System.out.println("------------------------------");
        System.out.printf("Subtotal: %.2f lei%n", subtotal);
        System.out.printf("Reducere regula stand: %.2f lei%n", reducere);
        System.out.printf("TOTAL: %.2f lei%n", total);

        if (areCadou()) {
            System.out.println("CADOU: " + cadou());
        }

        System.out.println("==============================");
    }
}
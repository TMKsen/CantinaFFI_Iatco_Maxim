
package lab4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Bon {

    private static int urmatorulNumar = 1;

    private final int numar;
    private final Comanda comanda;
    private final List<RegulaReducere> reguli;

    private RegulaReducere regulaAplicata;
    private BigDecimal reducereAplicata;

    public Bon(Comanda comanda, List<RegulaReducere> reguli) {

        if (comanda == null) {
            throw new IllegalArgumentException("Comanda nu poate fi null.");
        }

        if (reguli == null) {
            throw new IllegalArgumentException("Lista de reguli nu poate fi null.");
        }

        this.numar = urmatorulNumar++;
        this.comanda = comanda;
        this.reguli = new ArrayList<>(reguli);

        calculeazaCeaMaiBunaReducere();
    }

    private void calculeazaCeaMaiBunaReducere() {

        reducereAplicata = BigDecimal.ZERO.setScale(2);
        regulaAplicata = null;

        for (RegulaReducere regula : reguli) {

            if (regula == null) {
                continue;
            }

            BigDecimal reducere = regula.calculeazaReducere(comanda);

            if (reducere != null
                    && reducere.compareTo(reducereAplicata) > 0) {

                reducereAplicata = reducere;
                regulaAplicata = regula;
            }
        }

        if (reducereAplicata.compareTo(comanda.total()) > 0) {
            reducereAplicata = comanda.total();
        }

        reducereAplicata = reducereAplicata.setScale(2, RoundingMode.HALF_UP);
    }

    public int getNumar() {
        return numar;
    }

    public BigDecimal getReducereAplicata() {
        return reducereAplicata;
    }

    public RegulaReducere getRegulaAplicata() {
        return regulaAplicata;
    }

    public BigDecimal totalDupaReducere() {
        return comanda.total()
                .subtract(reducereAplicata)
                .max(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public boolean areCadou() {
        return numar % 4 == 0;
    }

    public String cadou() {
        return areCadou()
                ? "Topping gratuit la alegere"
                : "Fara cadou";
    }

    public void afiseaza() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("        BON NR. " + numar);
        System.out.println("==============================");

        for (LinieComanda linie : comanda.getLinii()) {
            System.out.println(linie);
        }

        System.out.println("------------------------------");
        System.out.printf("Subtotal: %.2f lei%n", comanda.total());

        System.out.printf(
                "Regula aplicata: %s%n",
                regulaAplicata == null
                        ? "Nicio reducere"
                        : regulaAplicata.getDenumire()
        );

        System.out.printf("Reducere: %.2f lei%n", reducereAplicata);
        System.out.printf("TOTAL: %.2f lei%n", totalDupaReducere());

        if (areCadou()) {
            System.out.println("CADOU: " + cadou());
        }

        System.out.println("==============================");
    }
}
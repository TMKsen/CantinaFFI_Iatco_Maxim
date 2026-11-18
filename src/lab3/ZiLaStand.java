package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZiLaStand {

    private final Produs[] produse;

    private int numarBonuri;
    private BigDecimal incasari = BigDecimal.ZERO;

    private final Map<Produs, Integer> vanzari = new LinkedHashMap<>();

    public ZiLaStand(Produs[] produse) {
        this.produse = produse;

        for (Produs produs : produse) {
            vanzari.put(produs, 0);
        }
    }

    private void inregistreazaVanzari(Comanda comanda) {

        for (LinieComanda linie : comanda.getLinii()) {

            Produs produs = linie.getProdus();

            if (produs instanceof MeniuCombo) {
                continue;
            }

            vanzari.merge(
                    produs,
                    linie.getCantitate(),
                    Integer::sum
            );
        }
    }

    private void proceseazaComanda(
            String denumire,
            Comanda comanda
    ) {

        System.out.println();
        System.out.println("********************************");
        System.out.println(denumire);
        System.out.println("********************************");

        if (comanda.esteGoala()) {
            System.out.println("Comanda este goala.");
            return;
        }

        Bon bon = new Bon(comanda);

        bon.afiseaza();

        numarBonuri++;

        incasari = incasari
                .add(bon.totalDupaRegula())
                .setScale(2, RoundingMode.HALF_UP);

        inregistreazaVanzari(comanda);
    }

    public void ruleaza() {

        System.out.println();
        System.out.println("================================");
        System.out.println("       ZI LA SWEET CORNER");
        System.out.println("================================");

        // Comanda 1
        Comanda c1 = new Comanda();
        c1.adauga(produse[0], 1);
        c1.adauga(produse[4], 1);

        proceseazaComanda(
                "Comanda 1 - produse simple",
                c1
        );

        // Comanda 2 - combo
        MeniuCombo combo = new MeniuCombo(
                "Combo Sweet Morning",
                10
        );

        combo.adaugaComponenta(produse[1]);
        combo.adaugaComponenta(produse[4]);

        Comanda c2 = new Comanda();
        c2.adauga(combo, 1);

        proceseazaComanda(
                "Comanda 2 - meniu combo",
                c2
        );

        // Comanda 3 - regula proprie
        Comanda c3 = new Comanda();
        c3.adauga(produse[2], 1);
        c3.adauga(produse[3], 1);

        proceseazaComanda(
                "Comanda 3 - regula proprie activa",
                c3
        );

        // Comanda 4 - cadou
        Comanda c4 = new Comanda();
        c4.adauga(produse[5], 1);

        proceseazaComanda(
                "Comanda 4 - bon cu cadou",
                c4
        );

        // Comanda 5 - stoc insuficient
        Comanda c5 = new Comanda();

        c5.adauga(produse[0], 2);

        proceseazaComanda(
                "Comanda 5 - refuz partial din cauza stocului",
                c5
        );

        afiseazaRaportFinal();
    }

    private void afiseazaRaportFinal() {

        System.out.println();
        System.out.println("================================");
        System.out.println("       RAPORT FINAL AL ZILEI");
        System.out.println("================================");

        System.out.println("Numar bonuri: " + numarBonuri);

        System.out.printf(
                "Incasari totale: %.2f lei%n",
                incasari
        );

        Produs celMaiVandut = null;
        int maxim = 0;

        for (Map.Entry<Produs, Integer> entry : vanzari.entrySet()) {

            if (entry.getValue() > maxim) {
                maxim = entry.getValue();
                celMaiVandut = entry.getKey();
            }
        }

        if (celMaiVandut != null) {
            System.out.println(
                    "Produsul cel mai vandut: "
                            + celMaiVandut.getDenumire()
                            + " (" + maxim + " buc.)"
            );
        }

        System.out.println();
        System.out.println("STOC RAMAS:");

        for (Produs produs : produse) {

            System.out.println(
                    produs.getDenumire()
                            + " -> "
                            + produs.getStoc()
            );
        }
    }
}
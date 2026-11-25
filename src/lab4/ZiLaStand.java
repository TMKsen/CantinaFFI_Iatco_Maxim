
package lab4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ZiLaStand {

    public static void main(String[] args) {

        // 1. Cream produsele
        Clatita clatita = new Clatita(
                "Clatita cu ciocolata", 25.00, 20, Topping.CIOCOLATA);

        Waffle waffle = new Waffle(
                "Waffle cu caramel", 30.00, 20, true);

        Bautura bautura = new Bautura(
                "Limonada", 15.00, 25, 500);

        BauturaCalda cafea = new BauturaCalda(
                "Cappuccino", 22.00, 20, 250, 80);

        // 2. Cream catalogul
        Catalog catalog = new Catalog();
        catalog.adauga(clatita);
        catalog.adauga(waffle);
        catalog.adauga(bautura);
        catalog.adauga(cafea);

        System.out.println("===== CATALOG INITIAL =====");
        catalog.afiseaza();

        // 3. Afisam produsele preparabile si personalizabile
        System.out.println("\n===== INTERFETE =====");

        for (Produs produs : catalog.getProduse()) {
            if (produs instanceof Preparabil) {
                Preparabil p = (Preparabil) produs;
                System.out.println(p.modPreparare());
            }

            if (produs instanceof Personalizabil) {
                Personalizabil p = (Personalizabil) produs;
                System.out.println(p.optiuniPersonalizare());
            }
        }

        // 4. Definim regulile de reducere
        List<RegulaReducere> reguli = new ArrayList<>();

        reguli.add(new ReducereProcentuala(9));
        reguli.add(new ReducerePrag());
        reguli.add(new ReducereWaffle());

        // Regula suplimentara definita prin lambda
        RegulaReducere reducereLambda = comanda ->
                comanda.total().compareTo(BigDecimal.valueOf(150)) >= 0
                        ? BigDecimal.valueOf(5)
                        : BigDecimal.ZERO.setScale(2);

        reguli.add(reducereLambda);

        // 5. Simulam sase comenzi
        List<Bon> bonuri = new ArrayList<>();

        Comanda c1 = new Comanda();
        c1.adauga(clatita, 2);
        c1.adauga(bautura, 1);
        bonuri.add(new Bon(c1, reguli));

        Comanda c2 = new Comanda();
        c2.adauga(waffle, 2);
        c2.adauga(cafea, 1);
        bonuri.add(new Bon(c2, reguli));

        Comanda c3 = new Comanda();
        c3.adauga(clatita, 1);
        c3.adauga(waffle, 1);
        c3.adauga(bautura, 2);
        bonuri.add(new Bon(c3, reguli));

        Comanda c4 = new Comanda();
        c4.adauga(cafea, 2);
        c4.adauga(waffle, 2);
        bonuri.add(new Bon(c4, reguli));

        Comanda c5 = new Comanda();
        c5.adauga(clatita, 3);
        c5.adauga(cafea, 1);
        bonuri.add(new Bon(c5, reguli));

        Comanda c6 = new Comanda();
        c6.adauga(waffle, 3);
        c6.adauga(bautura, 2);
        bonuri.add(new Bon(c6, reguli));

        // 6. Afisam bonurile si calculam venitul
        BigDecimal venitTotal = BigDecimal.ZERO;

        Map<String, BigDecimal> reduceriPeReguli = new LinkedHashMap<>();

        for (RegulaReducere regula : reguli) {
            reduceriPeReguli.put(
                    regula.getDenumire(), BigDecimal.ZERO);
        }

        System.out.println("\n===== BONURI =====");

        for (Bon bon : bonuri) {
            bon.afiseaza();

            venitTotal = venitTotal.add(bon.totalDupaReducere());

            if (bon.getRegulaAplicata() != null) {
                String nume = bon.getRegulaAplicata().getDenumire();

                reduceriPeReguli.put(
                        nume,
                        reduceriPeReguli.get(nume)
                                .add(bon.getReducereAplicata()));
            }
        }

        // 7. Afisam venitul total
        System.out.println("\n===== RAPORT FINANCIAR =====");
        System.out.println("Venit total: " + venitTotal + " lei");

        // 8. Afisam reducerile aplicate pentru fiecare regula
        System.out.println("\n===== REDUCERI PE REGULI =====");

        for (Map.Entry<String, BigDecimal> entry
                : reduceriPeReguli.entrySet()) {

            System.out.println(
                    entry.getKey() + ": "
                            + entry.getValue() + " lei");
        }

        // 9. Afisam top 3 produse vandute
        System.out.println("\n===== TOP 3 PRODUSE VANDUTE =====");

        List<Produs> topProduse =
                catalog.top(3, ComparatoareProdus.DUPA_VANZARI);

        for (Produs produs : topProduse) {
            System.out.println(
                    produs.getDenumire()
                            + " - " + produs.getVandute() + " bucati");
        }

        // 10. Afisam valoarea stocului ramas
        System.out.println("\n===== STOC FINAL =====");
        catalog.afiseaza();

        System.out.println(
                "Valoarea stocului ramas: "
                        + catalog.valoareStoc() + " lei");

        System.out.println("\n===== SFARSITUL ZILEI =====");
    }
}
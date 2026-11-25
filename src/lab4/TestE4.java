
package lab4;

public class TestE4 {

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        Clatita clatita = new Clatita(
                "Clatita cu ciocolata", 25.00, 20, Topping.CIOCOLATA);

        Waffle waffle = new Waffle(
                "Waffle cu caramel", 30.00, 15, true);

        BauturaCalda cappuccino = new BauturaCalda(
                "Cappuccino", 22.00, 30, 250, 80);

        catalog.adauga(clatita);
        catalog.adauga(waffle);
        catalog.adauga(cappuccino);

        // Inregistram vanzarile
        clatita.consumaStoc(5);
        waffle.consumaStoc(8);
        cappuccino.consumaStoc(12);

        System.out.println("===== TOP 3 DUPA PRET =====");
        for (Produs produs : catalog.top(3, ComparatoareProdus.DUPA_PRET)) {
            System.out.println(produs);
        }

        System.out.println("\n===== TOP 3 DUPA VANZARI =====");
        for (Produs produs : catalog.top(3, ComparatoareProdus.DUPA_VANZARI)) {
            System.out.println(
                    produs.getDenumire() + " - vandute: " + produs.getVandute()
            );
        }

        System.out.println("\n===== SORTARE ALFABETICA =====");
        catalog.getProduse().stream()
                .sorted()
                .forEach(System.out::println);
    }
}
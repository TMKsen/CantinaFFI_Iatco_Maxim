
package lab4;

public class TestE3 {

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        catalog.adauga(new Clatita(
                "Clatita cu ciocolata",
                25.00, 10, Topping.CIOCOLATA
        ));

        catalog.adauga(new Waffle(
                "Waffle cu caramel",
                30.00, 8, true
        ));

        catalog.adauga(new BauturaCalda(
                "Cappuccino",
                22.00, 15, 250, 80
        ));

        catalog.afiseaza();

        System.out.println("\nValoarea totala a stocului: "
                + catalog.valoareStoc() + " lei");

        System.out.println("\nProduse din categoria Clatite:");

        for (Produs produs : catalog.dinCategoria("Clatite")) {
            System.out.println(produs);
        }
    }
}

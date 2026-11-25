
package lab4;

public class TestE1 {

    public static void main(String[] args) {

        Produs p1 = new Clatita(
                "Clatita cu ciocolata",
                25.00,
                10,
                Topping.CIOCOLATA
        );

        Produs p2 = new Waffle(
                "Waffle cu caramel",
                30.00,
                8,
                true
        );

        Produs p3 = new BauturaCalda(
                "Cappuccino",
                22.00,
                15,
                250,
                80
        );

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}

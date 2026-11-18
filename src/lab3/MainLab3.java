package lab3;

import java.util.Locale;

public class MainLab3 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Produs p1 = new Clatita(
                "Clatita cu ciocolata",
                25.00,
                10,
                Topping.CIOCOLATA
        );

        Produs p2 = new Clatita(
                "Clatita cu banane",
                28.00,
                8,
                Topping.FRUCTE
        );

        Produs p3 = new Waffle(
                "Waffle cu caramel",
                30.00,
                7,
                false
        );

        Produs p4 = new Waffle(
                "Waffle cu fructe",
                32.00,
                6,
                true
        );

        Produs p5 = new BauturaCalda(
                "Cappuccino",
                22.00,
                12,
                300,
                70
        );

        Produs p6 = new BauturaCalda(
                "Ciocolata calda",
                24.00,
                10,
                300,
                75
        );

        System.out.println("=== PRODUSE ===");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);

        System.out.println();
        System.out.println("ID produs 1 = " + p1.getId());
        System.out.println("ID produs 6 = " + p6.getId());
    }
}
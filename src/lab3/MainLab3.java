package lab3;

import java.math.BigDecimal;
import java.util.Locale;

public class MainLab3 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        System.out.println("======================================");
        System.out.println("       SWEET CORNER FFI");
        System.out.println("       Laboratorul 3");
        System.out.println("       N = 9");
        System.out.println("======================================");

        // ============================
        // CREAREA CELOR 6 PRODUSE
        // ============================

        Produs p1 = new Clatita(
                "Clatita cu ciocolata",
                25.00,
                1,
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

        Produs[] produse = {
                p1, p2, p3, p4, p5, p6
        };

        // ============================
        // ETAPA 2-3
        // ============================

        System.out.println();
        System.out.println("=== ETAPA 2-3: PRODUSE ===");

        for (Produs produs : produse) {
            System.out.println(produs);
        }

        System.out.println();
        System.out.println("ID primul produs: " + p1.getId());
        System.out.println("ID ultimul produs: " + p6.getId());

        // ============================
        // BIGDECIMAL
        // ============================

        System.out.println();
        System.out.println("=== EXPERIMENT BIGDECIMAL ===");

        double s = 0;

        for (int i = 0; i < 10; i++) {
            s += 0.10;
        }

        System.out.println("double: " + s);

        BigDecimal b = BigDecimal.ZERO;

        for (int i = 0; i < 10; i++) {
            b = b.add(new BigDecimal("0.10"));
        }

        System.out.println("BigDecimal: " + b);

        // ============================
        // ETAPA 6 - AGREGARE
        // ============================

        System.out.println();
        System.out.println("=== ETAPA 6: AGREGARE ===");

        Meniu meniuDimineata =
                new Meniu("Meniul diminetii");

        Meniu meniuZi =
                new Meniu("Meniul zilei");

        meniuDimineata.adaugaProdus(p5);
        meniuDimineata.adaugaProdus(p1);

        meniuZi.adaugaProdus(p5);
        meniuZi.adaugaProdus(p3);

        System.out.println(
                "Cappuccino in meniul diminetii: "
                        + meniuDimineata.getProduse().contains(p5)
        );

        System.out.println(
                "Cappuccino in meniul zilei: "
                        + meniuZi.getProduse().contains(p5)
        );

        System.out.println(
                "Pret cappuccino initial: "
                        + p5.getPret()
        );

        p5.setPret(25.00);

        System.out.println(
                "Pret cappuccino modificat: "
                        + p5.getPret()
        );

        meniuDimineata.afiseaza();
        meniuZi.afiseaza();

        meniuDimineata = null;

        System.out.println();
        System.out.println(
                "Dupa meniuDimineata = null:"
        );

        System.out.println(p5);

        // ============================
        // COMBO
        // ============================

        System.out.println();
        System.out.println("=== MENIU COMBO ===");

        MeniuCombo combo =
                new MeniuCombo(
                        "Combo Sweet Morning",
                        10
                );

        combo.adaugaComponenta(p2);
        combo.adaugaComponenta(p5);

        System.out.printf(
                "Pret combo: %.2f lei%n",
                combo.pretFinal()
        );

        System.out.println(
                "Combo disponibil: "
                        + combo.esteDisponibil(1)
        );

        // ============================
        // ZIUA LA STAND
        // ============================

        System.out.println();
        System.out.println("=== ETAPA 7 ===");

        ZiLaStand zi =
                new ZiLaStand(produse);

        zi.ruleaza();
    }
}
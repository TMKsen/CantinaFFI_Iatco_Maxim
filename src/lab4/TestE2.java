
package lab4;

import java.util.ArrayList;
import java.util.List;

public class TestE2 {

    public static void main(String[] args) {

        List<Produs> produse = new ArrayList<>();

        produse.add(new Clatita(
                "Clatita cu ciocolata",
                25.00, 10, Topping.CIOCOLATA
        ));

        produse.add(new Waffle(
                "Waffle cu caramel",
                30.00, 8, true
        ));

        produse.add(new BauturaCalda(
                "Cappuccino",
                22.00, 15, 250, 80
        ));

        for (Produs produs : produse) {

            System.out.println("\n" + produs);

            if (produs instanceof Preparabil) {
                Preparabil p = (Preparabil) produs;
                p.prepara();
            }

            if (produs instanceof Personalizabil) {
                Personalizabil p = (Personalizabil) produs;
                System.out.println(
                        "Personalizare: " + p.optiuniPersonalizare()
                );
            }
        }
    }
}

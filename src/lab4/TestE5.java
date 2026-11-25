
package lab4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestE5 {

    public static void main(String[] args) {

        // Cream regulile de reducere
        List<RegulaReducere> reguli = new ArrayList<>();

        reguli.add(new ReducereProcentuala(9));
        reguli.add(new ReducerePrag());
        reguli.add(new ReducereWaffle());

        // Regula implementata prin lambda
        RegulaReducere reducereLambda = comanda ->
                comanda != null
                        && comanda.total().compareTo(
                        BigDecimal.valueOf(150)) >= 0
                        ? BigDecimal.valueOf(5)
                        : BigDecimal.ZERO.setScale(2);

        reguli.add(reducereLambda);

        // Cream produsele
        Waffle waffle = new Waffle(
                "Waffle cu caramel", 30.00, 10, true);

        Clatita clatita = new Clatita(
                "Clatita cu ciocolata", 25.00, 10,
                Topping.CIOCOLATA);

        // Cream comanda
        Comanda comanda = new Comanda();

        comanda.adauga(waffle, 2);
        comanda.adauga(clatita, 1);

        // Cream bonul
        Bon bon = new Bon(comanda, reguli);

        // Afisam bonul
        bon.afiseaza();

        System.out.println("\n===== VERIFICARE REGULI =====");

        for (RegulaReducere regula : reguli) {
            System.out.println(
                    regula.getDenumire() + ": "
                            + regula.calculeazaReducere(comanda)
                            + " lei"
            );
        }
    }
}

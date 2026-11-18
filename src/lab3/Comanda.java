package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comanda {

    private final List<LinieComanda> linii = new ArrayList<>();

    public void adauga(Produs produs, int cantitate) {

        if (produs == null || cantitate <= 0) {
            System.out.println("Adaugare refuzata: date invalide.");
            return;
        }

        if (!produs.esteDisponibil(cantitate)) {
            System.out.println(
                    "Adaugare refuzata pentru "
                            + produs.getDenumire()
                            + ": stoc insuficient."
            );
            return;
        }

        for (LinieComanda linie : linii) {

            if (linie.getProdus().equals(produs)) {

                produs.consumaStoc(cantitate);
                linie.maresteCantitate(cantitate);

                return;
            }
        }

        produs.consumaStoc(cantitate);

        linii.add(new LinieComanda(produs, cantitate));
    }

    public List<LinieComanda> getLinii() {
        return Collections.unmodifiableList(linii);
    }

    public BigDecimal total() {

        BigDecimal total = BigDecimal.ZERO;

        for (LinieComanda linie : linii) {
            total = total.add(linie.subtotal());
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public boolean esteGoala() {
        return linii.isEmpty();
    }

    public int cantitateDinClasa(Class<?> tip) {

        int total = 0;

        for (LinieComanda linie : linii) {

            if (tip.isInstance(linie.getProdus())) {
                total += linie.getCantitate();
            }
        }

        return total;
    }

    public int cantitateDinProdus(Class<?> tip, int index) {

        int gasite = 0;

        for (LinieComanda linie : linii) {

            if (tip.isInstance(linie.getProdus())) {

                if (gasite == index) {
                    return linie.getCantitate();
                }

                gasite++;
            }
        }

        return 0;
    }
}
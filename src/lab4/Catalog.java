
package lab4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalog {

    private final List<Produs> produse;

    public Catalog() {
        produse = new ArrayList<>();
    }

    public void adauga(Produs produs) {
        if (produs == null) {
            throw new IllegalArgumentException(
                    "Produsul nu poate fi null."
            );
        }

        produse.add(produs);
    }

    public void afiseaza() {
        System.out.println("===== CATALOG PRODUSE =====");

        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }

    public BigDecimal valoareStoc() {
        BigDecimal total = BigDecimal.ZERO;

        for (Produs produs : produse) {
            BigDecimal pret = BigDecimal.valueOf(produs.pretFinal());
            BigDecimal valoare = pret.multiply(
                    BigDecimal.valueOf(produs.getStoc())
            );

            total = total.add(valoare);
        }

        return total;
    }

    public List<Produs> dinCategoria(String categorie) {
        List<Produs> rezultat = new ArrayList<>();

        if (categorie == null) {
            return rezultat;
        }

        for (Produs produs : produse) {
            if (produs.categorie().equalsIgnoreCase(categorie)) {
                rezultat.add(produs);
            }
        }

        return rezultat;
    }

    public List<Produs> getProduse() {
        return Collections.unmodifiableList(produse);
    }
}

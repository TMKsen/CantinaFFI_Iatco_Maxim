package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meniu {

    private final String denumire;
    private final List<Produs> produse = new ArrayList<>();

    public Meniu(String denumire) {
        if (denumire == null || denumire.isBlank()) {
            throw new IllegalArgumentException(
                    "Denumirea meniului nu poate fi vida."
            );
        }

        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    public void adaugaProdus(Produs produs) {

        if (produs != null && !produse.contains(produs)) {
            produse.add(produs);
        }
    }

    public List<Produs> getProduse() {
        return Collections.unmodifiableList(produse);
    }

    public void afiseaza() {

        System.out.println();
        System.out.println("=== " + denumire + " ===");

        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }
}
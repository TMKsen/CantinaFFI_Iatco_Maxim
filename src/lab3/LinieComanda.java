package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;

class LinieComanda {

    private final Produs produs;
    private int cantitate;

    LinieComanda(Produs produs, int cantitate) {
        if (produs == null) {
            throw new IllegalArgumentException(
                    "Produsul nu poate fi null."
            );
        }

        if (cantitate <= 0) {
            throw new IllegalArgumentException(
                    "Cantitatea trebuie sa fie pozitiva."
            );
        }

        this.produs = produs;
        this.cantitate = cantitate;
    }

    public Produs getProdus() {
        return produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void maresteCantitate(int cantitate) {
        if (cantitate > 0) {
            this.cantitate += cantitate;
        }
    }

    public BigDecimal subtotal() {
        return BigDecimal.valueOf(produs.pretFinal())
                .multiply(BigDecimal.valueOf(cantitate))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format(
                "%s x %d = %.2f lei",
                produs.getDenumire(),
                cantitate,
                subtotal()
        );
    }
}
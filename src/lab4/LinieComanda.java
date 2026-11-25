
package lab4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LinieComanda {

    private final Produs produs;
    private int cantitate;

    public LinieComanda(Produs produs, int cantitate) {
        if (produs == null || cantitate <= 0) {
            throw new IllegalArgumentException("Date invalide pentru linia comenzii.");
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
        return produs.getDenumire()
                + " x " + cantitate
                + " = " + subtotal() + " lei";
    }
}

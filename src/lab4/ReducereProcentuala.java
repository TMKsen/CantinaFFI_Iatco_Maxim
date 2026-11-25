
package lab4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReducereProcentuala implements RegulaReducere {

    private final BigDecimal procent;

    public ReducereProcentuala(double procent) {
        if (procent < 0 || procent > 100) {
            throw new IllegalArgumentException("Procent invalid.");
        }

        this.procent = BigDecimal.valueOf(procent);
    }

    @Override
    public String getDenumire() {
        return "Reducere procentuala " + procent + "%";
    }

    @Override
    public BigDecimal calculeazaReducere(Comanda comanda) {
        if (comanda == null || comanda.esteGoala()) {
            return BigDecimal.ZERO.setScale(2);
        }

        return comanda.total()
                .multiply(procent)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}


package lab4;

import java.math.BigDecimal;

public class ReducerePrag implements RegulaReducere {

    private static final BigDecimal PRAG =
            BigDecimal.valueOf(110);

    private static final BigDecimal REDUCERE =
            BigDecimal.TEN.setScale(2);

    @Override
    public String getDenumire() {
        return "Reducere 10 lei pentru comenzi de minimum 110 lei";
    }

    @Override
    public BigDecimal calculeazaReducere(Comanda comanda) {

        if (comanda == null || comanda.esteGoala()) {
            return BigDecimal.ZERO.setScale(2);
        }

        if (comanda.total().compareTo(PRAG) >= 0) {
            return REDUCERE;
        }

        return BigDecimal.ZERO.setScale(2);
    }
}
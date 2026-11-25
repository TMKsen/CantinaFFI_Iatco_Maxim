
package lab4;

import java.math.BigDecimal;

@FunctionalInterface
public interface RegulaReducere {

    BigDecimal calculeazaReducere(Comanda comanda);

    default String getDenumire() {
        return "Regula personalizata";
    }
}
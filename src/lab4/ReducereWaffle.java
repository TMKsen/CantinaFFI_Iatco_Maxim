
package lab4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReducereWaffle implements RegulaReducere {

    @Override
    public String getDenumire() {
        return "Reducere 25% pentru minimum 2 Waffle";
    }

    @Override
    public BigDecimal calculeazaReducere(Comanda comanda) {

        if (comanda == null || comanda.esteGoala()) {
            return BigDecimal.ZERO.setScale(2);
        }

        int numarWaffle = comanda.cantitateDinClasa(Waffle.class);

        if (numarWaffle >= 2) {

            for (LinieComanda linie : comanda.getLinii()) {

                if (linie.getProdus() instanceof Waffle) {

                    return BigDecimal.valueOf(linie.getProdus().pretFinal())
                            .multiply(BigDecimal.valueOf(0.25))
                            .setScale(2, RoundingMode.HALF_UP);
                }
            }
        }

        return BigDecimal.ZERO.setScale(2);
    }
}

package lab4;

import java.util.Comparator;

public class ComparatoareProdus {

    public static final Comparator<Produs> DUPA_PRET =
            Comparator.comparingDouble(Produs::pretFinal)
                    .reversed();

    public static final Comparator<Produs> DUPA_VANZARI =
            Comparator.comparingInt(Produs::getVandute)
                    .reversed();
}

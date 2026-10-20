
import java.util.Locale;

public class TabelCosturi {

    static void afiseazaTabelCosturi(double pret) {
        for (int portii = 1; portii <= 5; portii++) {
            System.out.printf(
                    "%d portii: %.2f lei%n",
                    portii, pret * portii
            );
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        afiseazaTabelCosturi(24.50);
    }
}
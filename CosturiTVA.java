
import java.util.Locale;

public class CosturiTVA {
    static final double TVA = 0.20;

    static double calculeazaCost(double pret, int portii) {
        return pret * portii * (1 + TVA);
    }

    static double calculeazaCost(
            double pret, int portii, boolean bursier) {

        double subtotal = pret * portii;

        if (bursier) {
            subtotal *= 0.85;
        }

        return subtotal * (1 + TVA);
    }

    static double calculeazaCost(Produs p, int portii) {
        return calculeazaCost(p.getPret(), portii);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.printf("%.2f%n", calculeazaCost(46.00, 2));
        System.out.printf("%.2f%n", calculeazaCost(46.00, 2, true));
        System.out.printf("%.2f%n", calculeazaCost(46, 2));

        Produs p = new Produs("Piure", 46.00, 20);
        System.out.printf("%.2f%n", calculeazaCost(p, 2));
    }
}
import java.util.Locale;
import java.util.Scanner;

public class BonFiscal {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        final double PRET_PIURE = 46.00;
        final double PROCENT_TVA = 0.20;
        final double PROCENT_REDUCERE = 0.15;

        System.out.println("=================================");
        System.out.println("           BON FISCAL");
        System.out.println("=================================");

        System.out.print("Număr porții de piure: ");
        int portii = scanner.nextInt();

        System.out.print("Student bursier? (1 = da, 0 = nu): ");
        int raspuns = scanner.nextInt();

        boolean bursier = raspuns == 1;

        double subtotal = portii * PRET_PIURE;

        double reducere;

        if (bursier) {
            reducere = subtotal * PROCENT_REDUCERE;
        } else {
            reducere = 0;
        }

        double sumaDupaReducere = subtotal - reducere;

        double tva = sumaDupaReducere * PROCENT_TVA;

        double total = sumaDupaReducere + tva;

        System.out.println();
        System.out.println("=================================");
        System.out.printf("Subtotal:       %.2f lei%n", subtotal);
        System.out.printf("Reducere:       %.2f lei%n", reducere);
        System.out.printf("TVA 20%%:        %.2f lei%n", tva);
        System.out.printf("Total:          %.2f lei%n", total);
        System.out.println("=================================");

        scanner.close();
    }
}

import java.util.Locale;
import java.util.Scanner;

public class CantinaA1 {
    static final double ZEAMA = 24.50;
    static final double PIURE = 46.00;
    static final double SALATA = 18.00;
    static final double COMPOT = 12.00;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double total = 0;
        int optiune;

        do {
            System.out.println("\n===== CANTINA FFI =====");
            System.out.println("1. Zeama - 24.50 lei");
            System.out.println("2. Piure - 46.00 lei");
            System.out.println("3. Salata - 18.00 lei");
            System.out.println("4. Compot - 12.00 lei");
            System.out.println("0. Finalizare");
            System.out.print("Alegeti produsul: ");

            optiune = sc.nextInt();

            switch (optiune) {
                case 1:
                    total += ZEAMA;
                    break;
                case 2:
                    total += PIURE;
                    break;
                case 3:
                    total += SALATA;
                    break;
                case 4:
                    total += COMPOT;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune inexistenta");
            }
        } while (optiune != 0);

        double reducere = total > 100 ? total * 0.15 : 0;
        System.out.printf("Total: %.2f lei%n", total);
        System.out.printf("Suma de plata: %.2f lei%n", total - reducere);

        sc.close();
    }
}
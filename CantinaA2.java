
import java.util.Locale;
import java.util.Scanner;

public class CantinaA2 {

    static void afiseazaMeniu() {
        System.out.println("\n1. Zeama - 24.50 lei");
        System.out.println("2. Piure - 46.00 lei");
        System.out.println("3. Salata - 18.00 lei");
        System.out.println("4. Compot - 12.00 lei");
        System.out.println("0. Finalizare");
    }

    static double pretProdus(int optiune) {
        switch (optiune) {
            case 1: return 24.50;
            case 2: return 46.00;
            case 3: return 18.00;
            case 4: return 12.00;
            default: return 0;
        }
    }

    static double aplicaReducere(double total) {
        return total > 100 ? total * 0.15 : 0;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double total = 0;
        int optiune;

        do {
            afiseazaMeniu();
            System.out.print("Alegeti produsul: ");
            optiune = sc.nextInt();

            if (optiune >= 1 && optiune <= 4) {
                total += pretProdus(optiune);
            } else if (optiune != 0) {
                System.out.println("Optiune inexistenta");
            }
        } while (optiune != 0);

        double reducere = aplicaReducere(total);

        System.out.printf("Total: %.2f lei%n", total);
        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("Suma de plata: %.2f lei%n", total - reducere);

        sc.close();
    }
}

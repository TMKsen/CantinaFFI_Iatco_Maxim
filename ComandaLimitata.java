
import java.util.Locale;
import java.util.Scanner;

public class ComandaLimitata {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double total = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Produs (1-4, 0 = stop): ");
            int optiune = sc.nextInt();

            if (optiune == 0) {
                break;
            }

            if (optiune < 1 || optiune > 4) {
                System.out.println("Optiune inexistenta");
                continue;
            }

            switch (optiune) {
                case 1: total += 24.50; break;
                case 2: total += 46.00; break;
                case 3: total += 18.00; break;
                case 4: total += 12.00; break;
            }
        }

        System.out.printf(
                "Total fara reducere: %.2f lei%n", total
        );

        sc.close();
    }
}
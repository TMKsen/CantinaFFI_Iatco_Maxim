import java.util.Locale;
import java.util.Scanner;

public class Cantina {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("          CANTINA FFI");
        System.out.println("           MENIUL ZILEI");
        System.out.println("======================================");

        System.out.printf("%-25s %10s%n", "Denumirea produsului", "Preț");
        System.out.println("--------------------------------------");

        System.out.printf("%-25s %10.2f lei%n",
                "Zeamă de casă", 24.50);

        System.out.printf("%-25s %10.2f lei%n",
                "Piure cu pârjoală", 46.00);

        System.out.printf("%-25s %10.2f lei%n",
                "Salată de varză", 18.00);

        System.out.printf("%-25s %10.2f lei%n",
                "Compot", 12.00);

        System.out.println("--------------------------------------");

        System.out.print("Introduceți numărul de porții de zeamă: ");
        int portii = scanner.nextInt();

        double pret = 24.50;
        double total = portii * pret;

        System.out.println("Costul total: " + total);

        scanner.close();
    }
}

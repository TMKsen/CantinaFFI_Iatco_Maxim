import java.util.Locale;
import java.util.Scanner;

public class BonDetaliat {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        Produs[] produse = {
                new Produs("Zeamă de casă", 24.50, 100),
                new Produs("Piure cu pârjoală", 46.00, 100),
                new Produs("Salată de varză", 18.00, 100),
                new Produs("Compot", 12.00, 100)
        };

        int[] cantitati = new int[produse.length];

        int alegere;

        do {

            System.out.println();
            System.out.println("========== MENIU ==========");

            for (int i = 0; i < produse.length; i++) {

                System.out.printf(
                        "%d. %-25s %.2f lei%n",
                        i + 1,
                        produse[i].getDenumire(),
                        produse[i].getPret()
                );
            }

            System.out.println("0. Finalizare");

            System.out.print("Alegeți produsul: ");
            alegere = scanner.nextInt();

            if (alegere >= 1 && alegere <= produse.length) {

                int index = alegere - 1;

                System.out.print("Număr de porții: ");
                int portii = scanner.nextInt();

                if (produse[index].esteDisponibil(portii)) {

                    cantitati[index] += portii;

                    System.out.println(
                            "Produsul a fost adăugat în comandă."
                    );

                } else {

                    System.out.println(
                            "Număr de porții invalid sau stoc insuficient."
                    );
                }

            } else if (alegere != 0) {

                System.out.println("Opțiune invalidă.");
            }

        } while (alegere != 0);

        double subtotal = 0;

        System.out.println();
        System.out.println("======================================");
        System.out.println("             BON DETALIAT");
        System.out.println("======================================");

        for (int i = 0; i < produse.length; i++) {

            if (cantitati[i] > 0) {

                double cost =
                        produse[i].costPentru(cantitati[i]);

                subtotal += cost;

                System.out.printf(
                        "%-25s x %d = %7.2f lei%n",
                        produse[i].getDenumire(),
                        cantitati[i],
                        cost
                );
            }
        }

        double reducere = 0;

        if (subtotal > 100) {
            reducere = subtotal * 0.15;
        }

        double total = subtotal - reducere;

        System.out.println("--------------------------------------");

        System.out.printf(
                "Subtotal:             %7.2f lei%n",
                subtotal
        );

        System.out.printf(
                "Reducere:             %7.2f lei%n",
                reducere
        );

        System.out.printf(
                "Total:                %7.2f lei%n",
                total
        );

        System.out.println("======================================");

        scanner.close();
    }
}
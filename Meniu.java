import java.util.Locale;
import java.util.Scanner;

public class Meniu {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        Produs[] produse = {
                new Produs("Zeamă de casă", 24.50, 100),
                new Produs("Piure cu pârjoală", 46.00, 100),
                new Produs("Salată de varză", 18.00, 100),
                new Produs("Compot", 12.00, 100)
        };

        double total = 0;

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

                    double cost =
                            produse[index].costPentru(portii);

                    total += cost;

                    System.out.printf(
                            "Cost poziție: %.2f lei%n",
                            cost
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

        double reducere = 0;

        if (total > 100) {
            reducere = total * 0.15;
        }

        double sumaPlata = total - reducere;

        System.out.println();
        System.out.println("========== REZULTAT ==========");

        System.out.printf(
                "Total acumulat: %.2f lei%n",
                total
        );

        System.out.printf(
                "Reducere:       %.2f lei%n",
                reducere
        );

        System.out.printf(
                "Suma de plată:  %.2f lei%n",
                sumaPlata
        );

        System.out.println("==============================");

        scanner.close();
    }
}
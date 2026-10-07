import java.util.Scanner;

public class TestProdus {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produs[] produse = {
                new Produs("Zeamă de casă", 24.50, 20),
                new Produs("Piure cu pârjoală", 46.00, 15),
                new Produs("Salată de varză", 18.00, 30),
                new Produs("Compot", 12.00, 25)
        };

        System.out.println("========== PRODUSE ==========");

        for (Produs produs : produse) {
            System.out.println(produs);
        }

        System.out.println();

        System.out.print("Introduceți denumirea produsului: ");
        String denumireCautata = scanner.nextLine();

        System.out.print("Introduceți numărul de porții: ");
        int portii = scanner.nextInt();

        boolean gasit = false;

        for (Produs produs : produse) {

            if (produs.getDenumire().equals(denumireCautata)) {

                gasit = true;

                if (produs.esteDisponibil(portii)) {

                    System.out.println("Produs disponibil.");

                    System.out.printf(
                            "Costul comenzii: %.2f lei%n",
                            produs.costPentru(portii)
                    );

                } else {

                    System.out.println(
                            "Stoc insuficient pentru numărul solicitat de porții."
                    );
                }

                break;
            }
        }

        if (!gasit) {
            System.out.println(
                    "Produsul solicitat nu există în meniu."
            );
        }

        scanner.close();
    }
}
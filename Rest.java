import java.util.Scanner;

public class Rest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Suma de plată: ");
        int sumaPlata = scanner.nextInt();

        System.out.print("Suma achitată: ");
        int sumaAchitata = scanner.nextInt();

        int rest = sumaAchitata - sumaPlata;

        System.out.println();
        System.out.println("Rest: " + rest + " lei");
        System.out.println("Descompunerea restului:");

        int bancnote500 = rest / 500;
        rest = rest % 500;

        int bancnote200 = rest / 200;
        rest = rest % 200;

        int bancnote100 = rest / 100;
        rest = rest % 100;

        int bancnote50 = rest / 50;
        rest = rest % 50;

        int bancnote20 = rest / 20;
        rest = rest % 20;

        int bancnote10 = rest / 10;
        rest = rest % 10;

        int bancnote5 = rest / 5;
        rest = rest % 5;

        int bancnote1 = rest / 1;

        System.out.println("500 lei: " + bancnote500);
        System.out.println("200 lei: " + bancnote200);
        System.out.println("100 lei: " + bancnote100);
        System.out.println("50 lei: " + bancnote50);
        System.out.println("20 lei: " + bancnote20);
        System.out.println("10 lei: " + bancnote10);
        System.out.println("5 lei: " + bancnote5);
        System.out.println("1 leu: " + bancnote1);

        scanner.close();
    }
}
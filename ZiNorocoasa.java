
import java.util.Locale;

public class ZiNorocoasa {

    static int genereazaNumar(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        int minim = 11;
        int maxim = 0;
        int aparitii7 = 0;

        for (int i = 0; i < 1000; i++) {
            int numar = genereazaNumar(1, 10);

            minim = Math.min(minim, numar);
            maxim = Math.max(maxim, numar);

            if (numar == 7) {
                aparitii7++;
            }
        }

        System.out.println("Minim: " + minim);
        System.out.println("Maxim: " + maxim);
        System.out.println("Aparitii 7: " + aparitii7);

        double total = 12.00;
        int numarNorocos = genereazaNumar(1, 10);

        if (numarNorocos == 7) {
            total -= 12.00;
            System.out.println("Compot gratuit!");
        }

        total = Math.max(0, total);
        total = Math.round(total * 100.0) / 100.0;

        System.out.println("Numar norocos: " + numarNorocos);
        System.out.printf("Total: %.2f lei%n", total);
    }
}
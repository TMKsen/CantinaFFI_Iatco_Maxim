
public class TestTransmitere {

    static double majoreazaPret(double pret) {
        pret *= 1.10;
        return pret;
    }

    static void majoreazaPret(Produs p) {
        p.setPret(p.getPret() * 1.10);
    }

    public static void main(String[] args) {
        double pret = 24.50;
        Produs produs = new Produs("Zeama", 24.50, 20);

        System.out.printf("Double inainte: %.2f%n", pret);
        double pretNou = majoreazaPret(pret);
        System.out.printf("Double returnat: %.2f%n", pretNou);
        System.out.printf("Double original: %.2f%n", pret);

        System.out.printf(
                "Produs inainte: %.2f%n", produs.getPret()
        );

        majoreazaPret(produs);

        System.out.printf(
                "Produs dupa: %.2f%n", produs.getPret()
        );
    }
}
public class TestNumarProduse {

    public static void main(String[] args) {
        new Produs("Zeama", 24.50, 20);
        new Produs("Piure", 46.00, 20);
        new Produs("Salata", 18.00, 20);
        new Produs("Compot", 12.00, 20);

        System.out.println(
                "Numărul de produse: "
                        + Produs.getNumarProduse()
        );
    }
}
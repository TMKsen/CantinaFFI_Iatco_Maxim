public class TestCod {

    public static void main(String[] args) {

        Produs produs1 =
                new Produs("Zeamă de casă", 24.50, 20);

        Produs produs2 =
                new Produs("Piure cu pârjoală", 46.00, 15);

        Produs produs3 =
                new Produs("Salată de varză", 18.00, 30);

        Produs produs4 =
                new Produs("Compot", 12.00, 25);

        System.out.println(
                produs1.getDenumire() + " -> "
                        + produs1.codScurt()
        );

        System.out.println(
                produs2.getDenumire() + " -> "
                        + produs2.codScurt()
        );

        System.out.println(
                produs3.getDenumire() + " -> "
                        + produs3.codScurt()
        );

        System.out.println(
                produs4.getDenumire() + " -> "
                        + produs4.codScurt()
        );
    }
}
package lab3;

public enum Topping {
    CIOCOLATA(3.00),
    FRUCTE(4.00),
    CARAMEL(2.50);

    private final double pretSuplimentar;

    Topping(double pretSuplimentar) {
        this.pretSuplimentar = pretSuplimentar;
    }

    public double getPretSuplimentar() {
        return pretSuplimentar;
    }
}
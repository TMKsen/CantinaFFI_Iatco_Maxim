package lab3;

public class Clatita extends Produs {
    private final Topping topping;

    public Clatita(
            String denumire,
            double pret,
            int stoc,
            Topping topping
    ) {
        super(denumire, pret, stoc);
        this.topping = topping;
    }

    public Topping getTopping() {
        return topping;
    }

    @Override
    public double pretFinal() {
        return super.pretFinal() + topping.getPretSuplimentar();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", topping=" + topping;
    }
}
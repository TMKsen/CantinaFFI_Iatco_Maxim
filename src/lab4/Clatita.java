
package lab4;

public class Clatita extends Produs
        implements Preparabil, Personalizabil {

    private final Topping topping;

    public Clatita(
            String denumire,
            double pret,
            int stoc,
            Topping topping
    ) {
        super(denumire, pret, stoc);

        if (topping == null) {
            throw new IllegalArgumentException("Topping-ul nu poate fi null.");
        }

        this.topping = topping;
    }

    public Topping getTopping() {
        return topping;
    }

    @Override
    public double pretFinal() {
        return super.getPret() + topping.getPretSuplimentar();
    }

    @Override
    public String categorie() {
        return "Clatite";
    }

    @Override
    public String toString() {
        return super.toString() + ", topping=" + topping;
    }
    @Override
    public String modPreparare() {
        return "Clatita se prepara pe plita.";
    }

    @Override
    public String optiuniPersonalizare() {
        return "Topping: " + topping;
    }
}

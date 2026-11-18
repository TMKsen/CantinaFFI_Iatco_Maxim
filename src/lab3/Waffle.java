package lab3;

public class Waffle extends Produs {
    private final boolean extraCrocant;

    public Waffle(
            String denumire,
            double pret,
            int stoc,
            boolean extraCrocant
    ) {
        super(denumire, pret, stoc);
        this.extraCrocant = extraCrocant;
    }

    public boolean isExtraCrocant() {
        return extraCrocant;
    }

    @Override
    public double pretFinal() {
        if (extraCrocant) {
            return super.pretFinal() + 3.00;
        }

        return super.pretFinal();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", extraCrocant=" + extraCrocant;
    }
}
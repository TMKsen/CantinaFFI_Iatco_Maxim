
package lab4;

public class Waffle extends Produs
        implements Preparabil, Personalizabil {

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
            return super.getPret() + 3.00;
        }

        return super.getPret();
    }

    @Override
    public String categorie() {
        return "Waffle";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", extraCrocant=" + extraCrocant;
    }
    @Override
    public String modPreparare() {
        return "Waffle se prepara in aparatul special.";
    }

    @Override
    public String optiuniPersonalizare() {
        return extraCrocant
                ? "Extra crocant"
                : "Varianta clasica";
    }
}

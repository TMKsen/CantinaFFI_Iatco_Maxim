package lab3;

public class Bautura extends Produs {
    private final double volumMl;

    public Bautura(
            String denumire,
            double pret,
            int stoc,
            double volumMl
    ) {
        super(denumire, pret, stoc);

        if (volumMl <= 0) {
            throw new IllegalArgumentException(
                    "Volumul trebuie sa fie pozitiv."
            );
        }

        this.volumMl = volumMl;
    }

    public double getVolumMl() {
        return volumMl;
    }

    @Override
    public double pretFinal() {
        return super.pretFinal();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", volumMl=" + volumMl;
    }
}
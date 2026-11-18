package lab3;

public class BauturaCalda extends Bautura {
    private final int temperatura;

    public BauturaCalda(
            String denumire,
            double pret,
            int stoc,
            double volumMl,
            int temperatura
    ) {
        super(denumire, pret, stoc, volumMl);

        if (temperatura < 40 || temperatura > 100) {
            throw new IllegalArgumentException(
                    "Temperatura trebuie sa fie intre 40 si 100 grade."
            );
        }

        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }

    @Override
    public double pretFinal() {
        return super.pretFinal() + 1.00;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", temperatura=" + temperatura;
    }
}
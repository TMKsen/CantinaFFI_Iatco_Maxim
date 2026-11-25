
package lab4;

import java.util.Objects;

public abstract class Produs implements Comparable<Produs> {

    private static int urmatorulId = 1;

    protected final int id;
    protected String denumire;
    protected double pret;
    protected int stoc;
    protected int vandute;

    public Produs(String denumire, double pret) {
        this(denumire, pret, 0);
    }

    public Produs(String denumire, double pret, int stoc) {
        if (denumire == null || denumire.isBlank()) {
            throw new IllegalArgumentException("Denumirea nu poate fi vida.");
        }

        if (pret < 0) {
            throw new IllegalArgumentException("Pretul nu poate fi negativ.");
        }

        if (stoc < 0) {
            throw new IllegalArgumentException("Stocul nu poate fi negativ.");
        }

        this.id = urmatorulId++;
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
        this.vandute = 0;
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public int getStoc() {
        return stoc;
    }

    public int getVandute() {
        return vandute;
    }

    public void setPret(double pret) {
        if (pret < 0) {
            throw new IllegalArgumentException("Pretul nu poate fi negativ.");
        }

        this.pret = pret;
    }

    public abstract double pretFinal();

    public abstract String categorie();

    public boolean esteDisponibil(int cantitate) {
        return cantitate > 0 && stoc >= cantitate;
    }

    public void consumaStoc(int cantitate) {
        if (!esteDisponibil(cantitate)) {
            throw new IllegalArgumentException("Stoc insuficient.");
        }

        stoc -= cantitate;
        vandute += cantitate;
    }

    public void refaceStoc(int cantitate) {
        if (cantitate > 0) {
            stoc += cantitate;
        }
    }

    @Override
    public int compareTo(Produs altProdus) {
        return this.denumire.compareToIgnoreCase(altProdus.denumire);
    }

    @Override
    public String toString() {
        return String.format(
                "Produs{id=%d, denumire='%s', categorie='%s', pretFinal=%.2f, stoc=%d}",
                id, denumire, categorie(), pretFinal(), stoc
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Produs)) {
            return false;
        }

        Produs produs = (Produs) o;
        return id == produs.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
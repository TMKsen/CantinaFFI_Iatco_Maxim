public class Produs {

    private final String denumire;
    private final double pret;
    private final int stoc;

    public Produs(String denumire, double pret, int stoc) {
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
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

    public double costPentru(int portii) {
        return pret * portii;
    }

    public boolean esteDisponibil(int portii) {
        return portii > 0 && portii <= stoc;
    }

    public String codScurt() {
        return denumire.substring(0, 3).toUpperCase()
                + (int) pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", stoc=" + stoc +
                '}';
    }
}
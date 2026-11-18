package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeniuCombo extends Produs {

    private static final double REDUCERE = 0.13;

    private final List<Produs> componente = new ArrayList<>();

    public MeniuCombo(
            String denumire,
            int stoc
    ) {
        super(denumire, 0, stoc);
    }

    public void adaugaComponenta(Produs produs) {

        if (produs != null) {
            componente.add(produs);
        }
    }

    public List<Produs> getComponente() {
        return Collections.unmodifiableList(componente);
    }

    @Override
    public double pretFinal() {

        double suma = 0;

        for (Produs produs : componente) {
            suma += produs.pretFinal();
        }

        return suma * (1 - REDUCERE);
    }

    @Override
    public boolean esteDisponibil(int cantitate) {

        if (cantitate <= 0) {
            return false;
        }

        for (Produs produs : componente) {

            if (!produs.esteDisponibil(cantitate)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void consumaStoc(int cantitate) {

        if (!esteDisponibil(cantitate)) {
            throw new IllegalArgumentException(
                    "Combo indisponibil: o componenta nu are suficient stoc."
            );
        }

        for (Produs produs : componente) {
            produs.consumaStoc(cantitate);
        }
    }

    @Override
    public String toString() {

        return super.toString()
                + ", componente=" + componente.size()
                + ", reducereCombo=13%";
    }
}
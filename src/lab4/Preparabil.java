
package lab4;

public interface Preparabil {

    String modPreparare();

    default void prepara() {
        System.out.println("Se prepara produsul: " + modPreparare());
    }
}

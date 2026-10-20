
public class ProgramCantina {

    static boolean esteDeschis(int ziua, int ora) {
        return (ziua >= 1 && ziua <= 5 && ora >= 8 && ora < 16)
                || (ziua == 6 && ora >= 9 && ora < 13);
    }

    public static void main(String[] args) {
        System.out.println(esteDeschis(3, 8));
        System.out.println(esteDeschis(6, 12));
        System.out.println(esteDeschis(3, 16));
        System.out.println(esteDeschis(6, 13));
        System.out.println(esteDeschis(7, 10));
    }
}
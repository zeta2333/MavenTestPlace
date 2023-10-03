package usts.pycro.maventestplace;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-30 13:11
 */
public class MathTest {
    public static void main(String[] args) {
        System.out.println(Xop(3, -5));
        System.out.println(Xop(Xop(3, -5), -6));
    }

    public static int Xop(int a, int b) {
        return 2 * a * b + 1;
    }
}

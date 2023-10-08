package usts.pycro.maventestplace.classic.test;

import usts.pycro.maventestplace.classic.util.Complex;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-08 16:16
 */
public class ComplexTest {
    public static void main(String[] args) {
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(3, 5);
        System.out.println(c1.add(c2));
        System.out.println(c1.subtract(c2));
        System.out.printf("(%s) * (%s) = %s",c1,c2,c1.multiply(c2));
    }
}

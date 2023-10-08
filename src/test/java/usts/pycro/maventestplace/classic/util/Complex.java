package usts.pycro.maventestplace.classic.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-08 16:01
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complex {
    /**
     * 实部
     */
    private double realPart;
    /**
     * 虚部
     */
    private double imaginaryPart;

    @Override
    public String toString() {
        String imaginaryStr = String.valueOf(imaginaryPart);
        if (imaginaryPart - (int) imaginaryPart == 0) {
            imaginaryStr = String.valueOf((int) imaginaryPart);
        }
        String realStr = String.valueOf(realPart);
        if (realPart - (int) realPart == 0) {
            realStr = String.valueOf((int) realPart);
        }
        if (realStr.startsWith("-")) {
            return imaginaryStr + "i - " + realStr.substring(1);
        } else {
            return imaginaryStr + "i + " + realStr;
        }
    }

    public Complex add(Complex other) {
        return new Complex(realPart + other.realPart, imaginaryPart + other.imaginaryPart);
    }

    public Complex subtract(Complex other) {
        return new Complex(realPart - other.realPart, imaginaryPart - other.imaginaryPart);
    }

    public Complex multiply(Complex other) {
        double newRealPart = realPart * other.realPart - imaginaryPart * other.imaginaryPart;
        double newImaginaryPart = realPart * other.imaginaryPart + imaginaryPart * other.realPart;
        return new Complex(newRealPart, newImaginaryPart);
    }
}

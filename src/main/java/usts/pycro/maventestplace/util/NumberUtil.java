package usts.pycro.maventestplace.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-22 20:22
 */
@Component
public class NumberUtil {

    public static void main(String[] args) {
        String name = "马奇康";
        String pycro = "PYCRO";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < pycro.length(); i++) {
            code.append((pycro.charAt(i)) % 10);
        }
        int sum = 0;
        for (int i = 0; i < code.length(); i++) {
            sum += code.charAt(i) * (i + 1);
        }
        code.append(sum % 10);
        System.out.println(code);

    }


    public static String hashNum(String input, int length) {
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        BigInteger sum = new BigInteger("0");
        for (byte curByte : inputBytes) {
            BigInteger incr = pow(new BigInteger(Byte.toString(curByte)), (int) curByte);
            sum = sum.add(incr);
        }
        String sumString = sum.toString();
        return sumString.substring(sumString.length() - length);
    }

    public static BigInteger pow(BigInteger factor, Integer exp) {
        BigInteger base = new BigInteger("1");
        for (int i = 0; i < Math.abs(exp); i++) {
            base = base.multiply(factor);
        }
        return base;
    }
}

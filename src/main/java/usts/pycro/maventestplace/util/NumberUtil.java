package usts.pycro.maventestplace.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-22 20:22
 * 对于任意输入的字符串，输出一个确定的6位数
 */
@Component
public class NumberUtil {

    public static void main(String[] args) {
        System.out.print("请输入关键字：");
        String s = hashNum(new Scanner(System.in).next(), 6);
        System.out.println(s);
    }


    public static String hashNum(String input, int numLen) {
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        BigInteger factor = new BigInteger("1");
        for (byte curByte : inputBytes) {
            BigInteger incr = pow(new BigInteger(Byte.toString(curByte)), (int) curByte);
            factor = factor.multiply(incr);
        }
        System.out.println("乘积长度为：" + factor.toString().length());

        String divString = factor.divide(BigInteger.valueOf(factor.hashCode())).toString();
        // average select digit
        int strLen = divString.length();
        int blockLen = strLen / numLen;
        StringBuilder resNum = new StringBuilder();
        for (int i = 0; i < strLen; i += blockLen) {
            if (resNum.length() >= numLen) {
                break;
            }
            resNum.append(divString.charAt(strLen - 1 - i));
        }
        return resNum.toString();
    }

    public static BigInteger pow(BigInteger factor, Integer exp) {
        BigInteger base = new BigInteger("1");
        for (int i = 0; i < Math.abs(exp); i++) {
            base = base.multiply(factor);
        }
        return base;
    }
}

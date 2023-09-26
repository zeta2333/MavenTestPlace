package usts.pycro.maventestplace.util;

import java.util.Scanner;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-26 16:22
 */
public class BaseTransform {
    private final static String baseStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+\\";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int isContinue = 1;
        int base;
        int num;
        while (isContinue != 0) {
            System.out.print("请输入进制：");
            base = sc.nextInt();
            System.out.print("请输入需要转换的数字：");
            num = sc.nextInt();
            String res = convertBase(num, base);
            System.out.println("转换结果为：" + res);
            System.out.print("是否继续（1继续，0退出）：");
            isContinue = sc.nextInt();
        }
    }

    public static String convertBase(int input, int x) {
        if (Math.abs(input) > 10_0000_0000) {
            System.out.println("输入的数字不可大于10亿");
            System.exit(-1);
        }
        if (input >= 0) {
            return convertBasePositive(input, x);
        } else {
            return "-" + convertBasePositive(-input, x);
        }
    }

    public static String convertBasePositive(int posNum, int x) {
        StringBuilder res = new StringBuilder();
        while (posNum != 0) {
            res.append(baseStr.charAt((posNum % x)));
            posNum /= x;
        }
        return res.reverse().toString();
    }
}

package usts.pycro.maventestplace;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-30 13:11
 */
public class MathTest {
    public static void main(String[] args) {
        String s = DigestUtil.sha256Hex("123456");
    }



}

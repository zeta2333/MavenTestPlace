package MavenTestPlace.extensions.java.math.BigInteger;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigInteger;

@Extension
public class BigIntExtension {

    public static BigInteger plus(@This BigInteger thiz, BigInteger that) {
        return thiz.add(that);
    }

    public static BigInteger minus(@This BigInteger thiz, BigInteger that) {
        return thiz.subtract(that);
    }

    public static BigInteger times(@This BigInteger thiz, BigInteger that) {
        return thiz.multiply(that);
    }

    public static BigInteger div(@This BigInteger thiz, BigInteger that) {
        return thiz.divide(that);
    }
}
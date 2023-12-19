package MavenTestPlace.extensions.java.lang.Math;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

@Extension
public class MathExt {
    public static BigDecimal pow(@This Math thiz, BigDecimal b1, BigDecimal b2) {
        return BigDecimal.valueOf(Math.pow(b1.doubleValue(), b2.doubleValue()));
    }
}

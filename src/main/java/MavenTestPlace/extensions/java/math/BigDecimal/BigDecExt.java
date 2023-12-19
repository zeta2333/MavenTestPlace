package MavenTestPlace.extensions.java.math.BigDecimal;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

@Extension
public class BigDecExt {
    public static BigDecimal pow(@This BigDecimal thiz, BigDecimal that) {
        return BigDecimal.valueOf(Math.pow(thiz.doubleValue(), that.doubleValue()));
    }


}
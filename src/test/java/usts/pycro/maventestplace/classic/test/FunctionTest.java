package usts.pycro.maventestplace.classic.test;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-08 15:42
 */
public class FunctionTest {
    public static void main(String[] args) {
        double res = f(BigDecimal.valueOf(1.44),
                x -> x.add(BigDecimal.valueOf(1)).pow(3).doubleValue()
                        + x.add(BigDecimal.valueOf(2)).pow(2).doubleValue()
                        + x.add(BigDecimal.valueOf(3)).doubleValue()
                        + 4);
        System.out.println(res);
    }

    public static double f(BigDecimal x, Function<BigDecimal, Double> rule) {
        return rule.apply(x);
    }
}

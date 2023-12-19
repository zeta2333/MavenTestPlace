package usts.pycro.maventestplace;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSON;
import manifold.science.measures.Length;
import manifold.science.measures.Time;
import manifold.science.measures.Velocity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static manifold.science.util.CoercionConstants.bd;
import static manifold.science.util.CoercionConstants.bi;
import static manifold.science.util.UnitConstants.hr;
import static manifold.science.util.UnitConstants.m;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-30 13:11
 */
public class MathTest {
    public static void main(String[] args) {
        String text = "[\"北京市朝阳区建国路123号\",\"上海市浦东新区世纪大道456号\",\"山西省太原市小店区解放路1414号\",\"江苏省南京市鼓楼区中山路1010号\",\"浙江省杭州市西湖区文三路1111号\",\"四川省成都市武侯区天府大道2222号\",\"山东省青岛市市南区山东路333号\",\"福建省厦门市思明区湖滨北路444号\",\"山西省太原市小店区解放路1414号\",\"河南省郑州市金水区中原路666号\"]";
        List<String> strings = JSON.parseArray(text, String.class);
        List<String> collect = strings.stream().map(str -> str.replaceAll("\\d", "*")
        ).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void testManifold() {
        String str = "123\\456\\789";
        str.helloWorld();
        String[] split = str.split('\\');
        System.out.println(split.toString());
    }

    @Test
    public void testOpOverload() {
        Num n1 = new Num(1);
        Num n2 = new Num(2);
        Num n3 = new Num(3);
        System.out.println((n1 + n2 - n3 / n1));
    }

    @Test
    public void testBigIntOpOverload() {
        BigInteger a = 2bi;
        BigInteger b = 10bi;
        System.out.println("\$");
        System.out.println(a * b);
        System.out.println(a > b);
        System.out.println(a.pow(31));
    }

    @Test
    public void testScience() {
        int time = 8;
        BigDecimal x = 0.1bd;
        BigDecimal y = 0.2bd;

        Length l = 100m;
        Time t = 5hr;
        Date date = new Date(1673231707422L);
        System.out.println(date);
        Velocity v = l / t;
        System.out.println("v = ${v}");
        System.out.println("x + y = ${x + y}");
        System.out.println("0.7 + 0.2 = ${0.7 + 0.2}");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// (new Date());
        dateFormat.format(date);
        System.out.println("current time is ${time} in this class ${this.getClass().getSimpleName()}");
        System.out.println("Now is ${dateFormat.format(date)}");
    }


    /**
     * bubbleSort
     */
    @Test
    public void testBubbleSort() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void testHuTool2() {
    }

    @Test
    public void testHuTool() {
        Date date;
        String dateStr = "0001-01-01";
        date = DateUtil.parse(dateStr, "yyyy-MM-dd");
        System.out.println(new Date().getTime());
    }
}

class Num {
    private final int v;

    public Num(int v) {
        this.v = v;
    }

    public Num plus(Num that) {
        return new Num(this.v + that.v);
    }

    public Num minus(Num that) {
        return new Num(this.v - that.v);
    }

    public Num times(Num that) {
        return new Num(this.v * that.v);
    }

    public Num div(Num that) {
        return new Num(this.v / that.v);
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }
}
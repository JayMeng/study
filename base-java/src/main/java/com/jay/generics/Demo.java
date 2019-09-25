package com.jay.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jay
 * <p>
 * 泛型使用
 * @create 2019-08-12 14:51
 **/

public class Demo {


    public static void main(String[] args) {

        System.out.println(clsss("123"));
        System.out.println(clsss(1));
        System.out.println(clsss(new Date()));

        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        forEach(intArray);
        forEach(doubleArray);

        List intList = new ArrayList<>();
        intList.add(1);
        intList.add(1);
        List strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        //  下面的对泛型做了限制，只接受String 及其子类，所以int的集合会报错
        forEachList(intList);
        forEachList(strList);

        System.out.println(max(1, 2, 3));
        System.out.println(max(0.1, 0.2, 0.0));
        System.out.println(max(true, false, false));
    }

    /**
     * @return
     * @Author mj
     * @Description 泛型方法, 在方法的返回值前面使用泛型修饰 尖括号<T>，
     * 若想对类型加入限制。可以使用<T extends ?>
     * @Date 2019/8/12 14:56
     * @Param
     **/
    public static <T> T clsss(T t) {
        System.out.println(t.getClass());
        return t;
    }

    public static <T> void forEach(T[] arrays) {
        for (T value : arrays) {
            System.out.println(value);
        }
    }

    public static <T extends Comparable<T>> T max(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static <T extends String> void forEachList(List<T> t) {
        for (T value : t) {
            System.out.println(value);
        }
    }

    public static <X, Y, Z extends String> X demo2(X x, Y y, Z z) {
        System.out.println(x);
        System.out.println(y);
        return x;
    }


    public static <T> void demo4(List<T> list) {

    }

    public static void demo3(List<? extends String> a) {

    }
}




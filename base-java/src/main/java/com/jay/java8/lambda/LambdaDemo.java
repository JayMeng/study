package com.jay.java8.lambda;

/**
 * @author jay
 * @create 2019-08-15 10:18
 **/

public class LambdaDemo {
    public static void main(String[] args) {
        Convert<Integer, Integer> convert = (x, y) -> x + y;
        System.out.println(convert.add(1, 3));
    }

    public interface Convert<X, Y> {
        Integer add(X x, Y y);
    }
}




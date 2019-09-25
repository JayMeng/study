package com.jay.generics;

/**
 * @author jay
 * @create 2019-08-13 15:10
 **/

public class GenericTest<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


    public static void main(String[] args) {
        GenericTest<Integer> demo1 = new GenericTest<>();
        demo1.setT(1);
        System.out.println(demo1.getT());

        GenericTest<String> demo2 = new GenericTest<>();
        demo2.setT("汉密尔顿");
        System.out.println(demo2.getT());

        //demo2.setT(1);编码报错
    }
}




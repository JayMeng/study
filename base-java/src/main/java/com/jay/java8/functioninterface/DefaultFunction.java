package com.jay.java8.functioninterface;

/**
 * @author jay
 * @create 2019-08-15 16:45
 **/

public class DefaultFunction implements BasketBall, FootBall {
    @Override
    public void print() {
        BasketBall.super.print();
    }
}


interface BasketBall {
    default void print() {
        System.out.println("篮球");
    }
}


interface FootBall {
    default void print() {
        System.out.println("足球");
        }
        }
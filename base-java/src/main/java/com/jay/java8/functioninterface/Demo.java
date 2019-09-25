package com.jay.java8.functioninterface;

/**
 * @author jay
 * 函数式接口：有且仅有一个抽象方法，但是可以有多个非抽象方法的接口
 * <p>
 * <p>
 * 可以用lambda表达式来表示一个函数式接口的实现类，以前是用匿名内部类
 * 已知的函数式接口有：   Runnable
 * Callable
 * Comparator
 * FileFilter
 * InvocationHandler
 * PropertyChangeListener等等
 * @create 2019-08-15 15:26
 **/

public class Demo {

    public static void main(String[] args) {

        //  可以使用Lambda表达式来表示函数式接口的一个实现(注：JAVA 8 之前一般是用匿名类实现的)：
        MathService add = (a, b) -> a + b;
        MathService plus = (a, b) -> a * b;

        System.out.println(add.operate(2, 3));
        System.out.println(plus.operate(2, 3));
    }

    // 如下定义了一个函数式接口
    @FunctionalInterface
    interface MathService {
        Integer operate(Integer a, Integer b);

        //  函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口
        static void print(String s) {
            System.out.println(s);
        }

        //  函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，
        default void demo() {
            System.out.println("java8新特性，接口可以有默认方法--接口可以被实现");
        }
    }
}

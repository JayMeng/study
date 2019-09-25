package com.jay.java8.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * lambda基本使用
 *
 * @author jay
 * @create 2019-05-06 10:01
 **/

/**
 * 语法：(parameters -> expression)
 * 或者：(parameters -> {statements;})
 * <p>
 * 以下是lambda表达式的重要特征:
 * <p>
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 * <p>
 * demo:
 * () -> 5                     不需要参数,返回值为 5
 * x -> 2 * x                  接收一个参数(数字类型),返回其2倍的值
 * (x, y) -> x – y            接受2个参数(数字),并返回他们的差值
 * (int x, int y) -> x + y     接收2个int型整数,返回他们的和
 * (String s) -> System.out.print(s)   接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
 * <p>
 * <p>
 * tips:
 * 1.lambda表达式没有命名，用来像传递数据一样传递操作。
 * 2.函数接口指的是只有一个抽象方法的接口，被当做是lambda表达式的类型。
 */
public class Demo {

    public static void main(String[] args) {
        MathOperation mathOperation = (int a, int b) -> a + b;
        GreetingService greetingService = ((String a) -> System.out.println(a));
        System.out.println(mathOperation.operation(1, 2));
        greetingService.sayMessage("gagagag");
    }


    public static void list() {
        List<String> list1 = new ArrayList<>();
        list1.add("张三");
        list1.add("丽萨");
        list1.forEach(e -> System.out.println(e));
    }

    public static void map() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("篮球", "科比");
        map1.put("网球", "费德勒");
        map1.forEach((k, v) -> System.out.println(k + "," + v));
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}

package com.jay.java8.functioninterface;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author jay
 * @create 2019-09-24 15:58
 **/

public class PredicateDemo {

    public static void main(String[] args) {
        //  Predicate ;被用来定义某些情形的检查，类似于断言   - - - test
        Predicate<String> predicate = (s) -> s.startsWith("mj");
        System.out.println(predicate.test("mjmj"));

        //  Consumer ;被用来执行一些不用产生输出的动作        - - - accept
        Consumer consumer = (name) -> System.out.println(name + ",你好");
        consumer.accept("科比");

        //  Function ;将此函数应用于给定参数,并返回指定参数  - - - apply
        Function<Integer, String> function = i -> i + "是偶数么";
        System.out.println(function.apply(2));

        //  Supplier ;这个函数式接口不需要任何参数，却会产生一个值,可以被用来像下面这样生成唯一标志码。 - - - get
        Supplier supplier = () -> UUID.randomUUID().toString();
        System.out.println(supplier.get());

        // ----------------------------------------------------
        Function<String, Integer> strLength = String::length;
        Function<List<Integer>, Integer> maxFn = Collections::max;
//        Function<List<Integer>, Integer> maxFn = (numbers)-> Collections.max(numbers);


    }





}

package com.jay.java8.stream;

import com.jay.bean.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jay
 * @create 2019-09-25 9:42
 * <p>
 * <p>
 * Stream是一个高层的抽象，而不是一个数据结构。，Stream可以是列表、文件中的每行数据，或者其他任意元素的序列的一个视图，是一个来自数据源的元素队列并支持聚合操作
 * Java8允许你在集合对象上调用stream方法来创建一个Stream
 * <p>
 * Stream操作分为两大类，中间操作 + 结束操作
 * 中间操作 是从已有的Stream产生另一个Stream的函数 -> filter,map,sorted,distinct(去重)
 * 结束操作 是从Stream来产生一个不是Stream的结果的函数 -> collect(toList()),forEach,count
 **/

public class StreamDemo {

    public static void main(String[] args) {
        User mj = new User("mj");
        User yy = new User("yy");
        User nkx = new User("mkx");
        List<User> userList = new ArrayList<>();
        userList.add(mj);
        userList.add(yy);
        userList.add(nkx);

        List<String> names = userList.stream().filter(value -> value.getName().startsWith("m")).sorted((t1, t2) -> (t1.getName().length() - t2.getName().length())).map(user -> user.getName() + "来了").collect(Collectors.toList());
        names.forEach(System.out::println);

        //  优化,用方法引用替代lambda代码
        List<String> names2 = userList.stream().filter(user -> user.getName().startsWith("m")).sorted(Comparator.comparing(User::getName).reversed()).map(User::getName).collect(Collectors.toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 3);
        Stream<Integer> stream = numbers.stream().map(n -> n / 2);
        stream.collect(Collectors.toList());

    }
}

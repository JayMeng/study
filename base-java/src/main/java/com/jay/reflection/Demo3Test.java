package com.jay.reflection;

import java.lang.reflect.Method;

/**
 * @author jay
 * @create 2019-09-29 15:15
 **/

public class Demo3Test {
    public static void main(String[] args) throws Exception {
        // 使用反射调用方法
        // 需求1:调用public void doWork()
        // 获取类的字节码
        Class<Demo3> clz = Demo3.class;
        // 获取指定方法
        Method m = clz.getMethod("doWork");
        // 创建对象
        Object result = m.invoke(clz.newInstance());
        System.out.println(result);// null

        // 需求2:public static void doWork(String name)
        m = clz.getMethod("doWork", String.class);
        result = m.invoke(clz.newInstance(), "CoderZS");

        // 需求3:调用private String doNotWork(String name, int age)
        m = clz.getDeclaredMethod("doWork", String.class, int.class);
        m.setAccessible(true);
        result = m.invoke(clz.newInstance(), "CoderZS", 18);
        System.out.println(result);

        // 需求4,使用反射调用静态方法: 静态方法不属于任何对象,静态方法属于类本身.此时把invoke方法的第一个参数设置为null即可.
        m = clz.getDeclaredMethod("doWork", String.class, String.class, int.class);
        m.setAccessible(true);
        result = m.invoke(null, "CoderZS", "boy", 18);
        System.out.println(result);
    }
}

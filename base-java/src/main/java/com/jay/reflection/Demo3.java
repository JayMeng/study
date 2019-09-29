package com.jay.reflection;

import java.lang.reflect.Method;

/**
 * 使用反射调用方法: 1):获取方法所在类的字节码对象. 2):获取方法对象. 3):使用反射调用方法.
 * 如何使用反射调用一个方法:
 * 在Method类中有方法: public Object invoke(Object obj,Object...args):表示调用当前Method所表示的方法
 * 参数: obj: 表示被调用方法底层所属对象
 * Method m =clz.getMethod("doWork",String.class);
 * args:表示调用方法是传递的实际参数 返回: 底层方法的返回结果
 * 调用私有方法: 在调用私有方法之前:应该设置该方法为可访问的 又因为Method是AccessibleObject子类,所以Method中具有该方法.
 * doWorkMethod.setAccessible(true);
 */
public class Demo3 {
    public void doWork() {
        System.out.println("使用反射调用--无参--方法--doWork");
    }

    public void doWork(String name) {
        System.out.println("使用反射调用--有参--方法---doWork");
    }

    private String doWork(String name, int age) {
        return name + "使用反射调用--私有--方法" + age;
    }

    public static String doWork(String name, String sex, int age) {
        return name + "使用反射调用--静态--方法" + sex + age;
    }
}




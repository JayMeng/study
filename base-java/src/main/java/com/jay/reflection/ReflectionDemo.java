package com.jay.reflection;

import com.jay.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author jay
 * @create 2019-09-26 11:39
 **/

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        //  通过反射获取类的基本信息，构造器/属性/方法
        Class clazz = User.class;
        Arrays.stream(clazz.getConstructors()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.getName().equals("name")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        Arrays.stream(clazz.getMethods()).filter(method -> method.getName().startsWith("get")).collect(Collectors.toList()).forEach(System.out::println);

        //  通过反射构造对象，并控制对象的属性和行为（方法）
        Class demoClass = Class.forName("com.jay.bean.User");

        //  动态创建对象
        Constructor demoCon = demoClass.getConstructor(String.class);
        Object objct = demoCon.newInstance("测试");
        User userReflect = (User) objct;
        System.out.println("------------------------------------------------");
        System.out.println(userReflect.getName());

        //  动态获取对象的方法，行为
        Method method = demoClass.getMethod("setName", String.class);
        method.invoke(userReflect, "hahaha");
        System.out.println("------------------------------------------------");
        System.out.println(userReflect.getName());

        //  动态对对象的属性复制
        Field field = demoClass.getDeclaredField("mobile");
        //  私有属性设置可访问
        field.setAccessible(true);
        field.set(userReflect, "18651652132");
        System.out.println("------------------------------------------------");
        System.out.println(userReflect.getMobile());
    }
}

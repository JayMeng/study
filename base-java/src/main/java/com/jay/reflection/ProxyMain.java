package com.jay.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jay
 * 通过代理可以实现运行时的动态接口实现，
 * 所谓的动态代理，就是 运行时创建接口的动态实现
 * @create 2019-09-29 16:09
 **/

public class ProxyMain {
    public static void main(String[] args) {
        Object object = Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class[]{ProxyInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("")) {

                }
                return null;
            }
        });
        //  这时myInterface就已经包含了接口的动态实现
        ProxyInterface myInterface = (ProxyInterface) object;
    }
}

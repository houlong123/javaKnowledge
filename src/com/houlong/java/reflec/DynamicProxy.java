package com.houlong.java.reflec;

import com.houlong.java.io.NioServer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 代理类
 */
public class DynamicProxy implements InvocationHandler {

    private Object source;

    public DynamicProxy(Object source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理后的方法执行了");
        /**
         * Exception in thread "main" java.lang.IllegalArgumentException: object is not an instance of declaring class
             at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
             at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
             at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
             at java.lang.reflect.Method.invoke(Method.java:498)
             at com.houlong.java.reflec.DynamicProxy.invoke(DynamicProxy.java:21)
             at com.sun.proxy.$Proxy0.method1(Unknown Source)
             at com.houlong.java.reflec.DynamicProxy.main(DynamicProxy.java:31)

         因为此时的source对象为TestClass，而method实例则是TestInterface的，且TestClass并没有实现TestInterface接口，所以会报错

         可以通过下面方法处理：
         Method sourceMethod = source.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
         sourceMethod.setAccessible(true);
         return  sourceMethod.invoke(source, args);

         */

        return method.invoke(source, args);
    }

    public static void main(String[] args) {

        /**
         * 模拟在使用动态代理时，被代理对象必须实现了一个接口。
         */
        TestInterface proxy = (TestInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {TestInterface.class, InvocationHandler.class}, new DynamicProxy(new TestClass()));

        Class clazz = proxy.getClass();

        /**
         * 生成的代理类 继承了 Proxy 类，并且实现了在创建代理类时所传入的接口。
         */
        System.out.println(clazz.getGenericSuperclass());

        Type[] array = clazz.getGenericInterfaces();
        for (Type interfaceName : array ) {
            System.out.println(interfaceName.getTypeName());
        }

        proxy.method1();
        proxy.method2();
        proxy.method3();

        byte a = -64;
        byte b = -6;
        System.out.println(a/b + "_" + a%b);
    }
}

package com.houlong.java.reflec;

import java.lang.ref.PhantomReference;
import java.lang.reflect.Method;

/**
 * 反射测试
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {


        /**
         * Class.forName()除了将.class文件加载到JVM外，还会对类进行解释，执行类中的static块。
         * 当然Class.forName(name, initialize, loader)带参函数也可控制是否加载static块，
         * 当initialize=false时，只有调用了newInstance()方法进行对象创建的时候，才会执行类中的static块。
         */
        Class<?> clz = Class.forName("com.houlong.java.reflec.Demo");
        Method method = clz.getMethod("method", String.class);
        Object o = clz.newInstance();
        for (int index = 0; index < 20; index++) {
            method.invoke(o, Integer.toString(index));
        }
        System.in.read();

        String var1 = System.getProperty("sun.reflect.noInflation");
        System.out.println(var1);

        Thread t = new Thread();
        t.start();

        /**
         * ClassLoader主负责将.class文件加载到JVM，但是不会执行static代码块，
         * 只有在调用了newInstance方法进行对象创建的时候，才会执行static代码块
         */

        Class c=ReflectTest.class.getClassLoader().loadClass("com.houlong.java.reflec.Demo");
        System.out.println("玩");
        c.newInstance();
    }
}
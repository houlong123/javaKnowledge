package com.houlong.java.reflec;

/**
 * Created by houlong on 2018/4/5.
 */
public class Demo {

    static {
        System.out.println("执行Demo静态代码块");
    }

    public void method(String name) {
        System.out.println("hello " + name);
    }
}

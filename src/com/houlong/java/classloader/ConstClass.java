package com.houlong.java.classloader;

/**
 * Created by houlong on 2018/4/16.
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "hello world!";
}

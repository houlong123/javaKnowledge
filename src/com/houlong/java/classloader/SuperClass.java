package com.houlong.java.classloader;

/**
 * Created by houlong on 2018/4/16.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

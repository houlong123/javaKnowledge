package com.houlong.java.classloader;

/**
 * Created by houlong on 2018/4/16.
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init！");
    }
}

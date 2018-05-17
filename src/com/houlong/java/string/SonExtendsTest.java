package com.houlong.java.string;

/**
 * Created by houlong on 2018/4/2.
 */
public class SonExtendsTest extends ExtendsTest{

    public static final String staticField = "子类静态变量";

    public String field = "子类普通变量";
    static {
        System.out.println(staticField);
        System.out.println("2");
    }

     {
         System.out.println(field);
        System.out.println("子类初始化");
    }

    public SonExtendsTest() {
        System.out.println("b");
    }

    public static void main(String[] args) {
        ExtendsTest a = new SonExtendsTest();

        System.out.println("");
        System.out.println("--------------  验证静态变量，静态代码块只加载一次  ----------------");
        System.out.println("");
        a = new SonExtendsTest();
    }
}

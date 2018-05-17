package com.houlong.java.string;

/**
 * Created by houlong on 2018/4/2.
 */
public class ExtendsTest {

    public static final String staticField = "父类静态变量";
    public  String field = "父类普通变量";

    //静态代码块
    static {
        System.out.println(staticField);
        System.out.println("1");
    }

    //初始化块
    {
        System.out.println(field);
        System.out.println("父类初始化");
    }

    //构造函数
    public ExtendsTest() {
        System.out.println("a");
    }

    public static void main(String[] args) {
        new ExtendsTest();
    }
}

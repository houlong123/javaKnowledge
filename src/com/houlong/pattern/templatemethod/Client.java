/*
package com.houlong.pattern.templatemethod;


import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

*/
/**
 * 模板方法模式
 *//*

public class Client {

    private static final CallbackFilter ALL_ZERO = method -> 0;

    public static void main(String[] args) {
        Account account = new Account();
        account.handle("天下无贼", "123456", () -> System.out.println("按照活期计算利息！"));

        new Thread(() -> System.out.println("dd")).start();

        System.out.println("=========================");

        account.handle("天下无贼", "123456", () -> {
            int a = 10;
            int b = 11;
            int c = a + b;
            System.out.println("按照死期计算利息！" + c);
        });

        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(System.out::println);
    }
}
*/

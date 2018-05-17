package com.houlong.pattern.abstractFactory;

/**
 * concrete product
 */
public class SummerTextField implements TextField {

    @Override
    public void display() {
        System.out.println("显示浅蓝色文本域。");
    }
}

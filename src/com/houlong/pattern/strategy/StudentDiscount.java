package com.houlong.pattern.strategy;

/**
 * 具体策略类
 */
public class StudentDiscount implements Discount {

    @Override
    public double calculate(double price) {
        System.out.println("学生价，八折优惠！！！");
        return price * 0.8;
    }
}

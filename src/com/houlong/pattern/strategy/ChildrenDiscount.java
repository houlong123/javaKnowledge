package com.houlong.pattern.strategy;

/**
 * 具体策略类
 */
public class ChildrenDiscount implements Discount {

    @Override
    public double calculate(double price) {
        System.out.println("儿童价，全免！！！！");
        return 0;
    }
}

package com.houlong.pattern.strategy;

/**
 * 抽象策略类
 */
public interface Discount {
    public double calculate(double price);
}

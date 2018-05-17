package com.houlong.pattern.templatemethod;

/**
 * 计算利息，充当回调函数
 */
@FunctionalInterface
public interface CalculateInterestCallBack {
    /**
     * 计算利息
     */
    void calculateInterest();


    String toString();
}

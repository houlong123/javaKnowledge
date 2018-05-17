package com.houlong.pattern.simpleFactory;

/**
 * 具体产品类
 */
public class HistogramChat implements Chat {

    public HistogramChat() {
        System.out.println("创建直方图");
    }

    @Override
    public void display() {
        System.out.println("直方图展示");
    }
}

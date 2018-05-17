package com.houlong.pattern.simpleFactory;

/**
 * 具体产品类
 */
public class PieChart implements Chat {

    public PieChart() {
        System.out.println("创建饼状图");
    }

    @Override
    public void display() {
        System.out.println("饼状图展示");
    }
}

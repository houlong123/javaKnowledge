package com.houlong.pattern.simpleFactory;

/**
 * 具体产品类
 */
public class LineChat implements Chat {

    public LineChat() {
        System.out.println("创建直线图");
    }

    @Override
    public void display() {
        System.out.println("直线图展示");
    }
}

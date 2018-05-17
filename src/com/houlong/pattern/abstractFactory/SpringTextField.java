package com.houlong.pattern.abstractFactory;

/**
 * 具体产品
 */
public class SpringTextField implements TextField {

    @Override
    public void display() {
        System.out.println("显示浅绿色文本域。");
    }
}

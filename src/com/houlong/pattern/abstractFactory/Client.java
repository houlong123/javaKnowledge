package com.houlong.pattern.abstractFactory;

/**
 * 抽象工厂模式
 */
public class Client {

    public static void main(String[] args) {
        SkinFactory factory = new SpringSkinFactory();
        Button button = factory.createButton();
        TextField textField = factory.createTextField();
        button.display();
        textField.display();
    }
}

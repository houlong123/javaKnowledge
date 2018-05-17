package com.houlong.pattern.decorator;

/**
 * 装饰模式。拓展系统功能
 */
public class Client {

    public static void main(String[] args) {
        Component window, decorator, blackDecorator;
        window = new Window();
        decorator = new ScrollBarDecorator(window);
        blackDecorator = new BlackBorderDecorotor(decorator);

        blackDecorator.display();
    }
}

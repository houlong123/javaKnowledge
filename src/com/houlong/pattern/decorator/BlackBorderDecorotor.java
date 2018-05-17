package com.houlong.pattern.decorator;

/**
 * 具体构件类
 */
public class BlackBorderDecorotor extends ComponentDecorator {

    public BlackBorderDecorotor(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    private void setBlackBorder() {
        System.out.println("添加黑边");
    }
}

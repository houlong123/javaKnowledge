package com.houlong.pattern.decorator;

/**
 * 具体构件类
 */
public class Window extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }
}

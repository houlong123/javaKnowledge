package com.houlong.pattern.mediator;

/**
 * 具体同事类
 */
public class ComboBox extends Component {

    @Override
    public void update() {
        System.out.println("组合框新增一项：张无忌");
    }

    public void select() {
        System.out.println("组合框选中项：小龙女");
    }
}

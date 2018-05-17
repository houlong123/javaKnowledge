package com.houlong.pattern.mediator;

/**
 * 具体中介者类
 *
 */
public class ConcreteMediator extends Mediator {
    public Button button;
    public List list;
    public TextBox textBox;
    public ComboBox cb;

    @Override
    public void componentChanged(Component c) {
        if (c instanceof Button) {  //单击按钮
            System.out.println("--单击按钮--");
            list.update();
            cb.update();
            textBox.update();
        } else if(c instanceof List) {  //从列表框中选择客户
            System.out.println("--从列表框中选择客户--");
            cb.select();
            textBox.update();
        } else if(c instanceof ComboBox) {
            System.out.println("--从组合框中选择客户--");
            cb.select();
            textBox.setText();
        }
    }
}

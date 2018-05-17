package com.houlong.pattern.mediator;

/**
 * 中介者模式
 *
 */
public class Client {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Button button = new Button();
        List list = new List();
        ComboBox cb = new ComboBox();
        TextBox textBox = new TextBox();

        mediator.button = button;
        mediator.textBox = textBox;
        mediator.list = list;
        mediator.cb = cb;

        button.setMediator(mediator);
        list.setMediator(mediator);
        cb.setMediator(mediator);
        textBox.setMediator(mediator);

        button.changed();
        System.out.println("-------------------------");
        list.changed();
    }
}

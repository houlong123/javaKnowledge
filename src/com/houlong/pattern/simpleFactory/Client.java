package com.houlong.pattern.simpleFactory;

/**
 * 简单工厂模式
 */
public class Client {

    public static void main(String[] args) {
        Chat chat = ChatFactory.createChat("histogram");
        chat.display();
        System.out.println("---------------------");

        //简化的简单工厂模式
        Chat chat2 = Chat.createChat("pie");
        chat2.display();
    }
}

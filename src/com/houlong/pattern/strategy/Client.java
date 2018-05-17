package com.houlong.pattern.strategy;

/**
 * 策略模式，算法的封装与切换。实现一个功能有多条途径，每一条途径对应一种算法
 */
public class Client {

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        double originPrice = 120;
        ticket.setPrice(originPrice);
        System.out.println("原始票价为：" + originPrice);

        /*Discount childrenDiscount = new ChildrenDiscount();

        ticket.setDiscount(childrenDiscount);*/
        Discount discount = new StudentDiscount();
        ticket.setDiscount(discount);

        System.out.println("学生价为:" + ticket.getPrice());


    }
}

package com.houlong.pattern.builder;

/**
 * 建造者模式，创建复杂对象
 */
public class Client {

    public static void main(String[] args) {
        ActorDirect direct = new ActorDirect();
        Actor actor = direct.construct(new HeroBuilder());
        System.out.println(actor.getType() + "的外观:");
        System.out.println("性别:" + actor.getSex());
        System.out.println("面容:" + actor.getFace());
        System.out.println("服装:" + actor.getCostume());
        System.out.println("发型:" + actor.getHairstyle());
        System.out.println("-----------------");
        Actor actor2 = direct.construct(new DevilBuilder());
        System.out.println(actor2.getType() + "的外观:");
        System.out.println("性别:" + actor2.getSex());
        System.out.println("面容:" + actor2.getFace());
        System.out.println("服装:" + actor2.getCostume());
        System.out.println("发型:" + actor2.getHairstyle());
    }
}

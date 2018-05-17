package com.houlong.pattern.observer;

import java.util.Observable;

/**
 * 观察者模式，实现对象间的联动
 */
public class Client {

    public static void main(String[] args) {
        AllyControlCenter controlCenter = new ConcreteAllyControlCenter("无敌舰队");  //充当观察目标
        Observer player1, player2, player3, player4;    //充当观察者
        player1 = new Player("和谐号");
        controlCenter.join(player1);
        player2 = new Player("泰坦尼克号");
        controlCenter.join(player2);
        player3 = new Player("东方巨龙号");
        controlCenter.join(player3);
        player4 = new Player("天空一号");
        controlCenter.join(player4);

        player1.beAttacked(controlCenter);
    }
}

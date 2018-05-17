package com.houlong.pattern.observer;

/**
 * 具体观察者
 */
public class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("hold on！my friends, " + this.name + "is coming to help you");
    }

    @Override
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name + "was attacked！");
        acc.notifyObserver(name);
    }
}

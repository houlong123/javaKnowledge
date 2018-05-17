package com.houlong.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标类，内部关联具体观察者
 */
abstract class AllyControlCenter {

    protected String allyName;
    protected List<Observer> players = new ArrayList<>();

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }
    public String getAllyName(){
        return allyName;
    }

    public void join(Observer observer) {
        System.out.println(observer.getName() + "加入" + this.allyName + "战队!");
        players.add(observer);
    }

    public void quit(Observer observer) {
        System.out.println(observer.getName() + "退出" + this.allyName + "战队!");
        players.remove(observer);
    }

    public abstract void notifyObserver(String name);
}

package com.houlong.pattern.observer;

/**
 * 抽象观察者类
 */
interface Observer {
    public String getName();
    public void setName(String name);
    public void help();
    public void beAttacked(AllyControlCenter acc);
}

package com.houlong.pattern.flyweight;

/**
 * 红方
 */
public class RedChess extends Chess {

    //饿汉式单例模式
    private static RedChess instance = new RedChess();

    private RedChess(){}

    @Override
    String getColor() {
        return "红方";
    }

    public static RedChess getInstance(){
        return instance;
    }
}

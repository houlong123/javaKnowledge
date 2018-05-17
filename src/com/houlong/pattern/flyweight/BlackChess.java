package com.houlong.pattern.flyweight;

/**
 * 黑方
 */
public class BlackChess extends Chess {

    private volatile static BlackChess instance = null;

    private BlackChess() {

    }

    @Override
    String getColor() {
        return "黑方";
    }

    //懒汉式单例模式(双重检查锁定)
    public static BlackChess getInstance() {
        if (instance == null) {
            synchronized (BlackChess.class) {
                if (instance == null) {
                    instance = new BlackChess();
                }
            }
        }
        return instance;
    }
}

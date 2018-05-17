package com.houlong.pattern.memento;

/**
 * 备忘录对象，用于保存原发器的原始状态
 */
public class Memeto {

    public Memeto(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    private String name;
    private int x;
    private int y;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

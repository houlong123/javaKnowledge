package com.houlong.pattern.flyweight;

/**
 * 象棋抽象类
 */
abstract class Chess {
    private Location location;
    abstract String getColor();

    public void setLocation(Location location) {
        this.location = location;
    }

    public void display(String name, Location location) {
        System.out.println(this.getColor() + " " + name
                + "，位于：" + location.getX()+ "," + location.getY() +"出动");
    }

}

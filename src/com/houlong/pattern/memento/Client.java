package com.houlong.pattern.memento;

/**
 * 备忘录模式：实现撤销功能（内部类实现）
 */
public class Client {

    public static int index = -1;
    public static void main(String[] args) {
        Chessman chessman = new Chessman("帅",5,1);
        disPlay(chessman);
        chessman.setX(6);
        disPlay(chessman);
        chessman.setY(2);
        disPlay(chessman);
        System.out.println("悔棋啦===============");
        undo(chessman);
        undo(chessman);
    }

    private static void disPlay(Chessman chessman) {
        chessman.save();
        index++;
        System.out.println("棋子 " + chessman.getName() +" 的位置为：（" + chessman.getX() + "," + chessman.getY() + ")");
    }

    private static void undo(Chessman chessman) {
        System.out.println("******悔棋************");
        index--;
        chessman.restore(index);
        System.out.println("棋子 " + chessman.getName() +" 的位置为：（" + chessman.getX() + "," + chessman.getY() + ")");
    }
}

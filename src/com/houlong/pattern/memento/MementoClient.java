package com.houlong.pattern.memento;

/**
 * 备忘录模式（一般实现方式）
 */
public class MementoClient {

    private static MementoCaretaker caretaker = new MementoCaretaker();
    private static int index = -1;

    public static void main(String[] args) {
        Chessman chessman = new Chessman("帅", 5, 1);
        disPlay(chessman);
        chessman.setY(2);
        disPlay(chessman);
        chessman.setX(2);
        disPlay(chessman);
        undo(chessman);
        undo(chessman);
    }

    private static void disPlay(Chessman chessman) {
        caretaker.setMemeto(chessman.update());
        index++;
        System.out.println("棋子 " + chessman.getName() +" 的位置为：（" + chessman.getX() + "," + chessman.getY() + ")");
    }

    private static void undo(Chessman chessman) {
        System.out.println("悔棋了---------");
        index--;
        chessman.restore(caretaker.getMemeto(index));
        System.out.println("棋子 " + chessman.getName() +" 的位置为：（" + chessman.getX() + "," + chessman.getY() + ")");
    }
}

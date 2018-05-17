package com.houlong.pattern.flyweight;

/**
 *
 * 享元模式
 * 功能：实现对象的复用
 * 技术：享元模式通过共享技术实现相同或者相似对象的重用。
 * 技术关键：区分内部状态和外部状态
 *  内部状态：存储在享元对象的内部，并且不会随着环境的变化而改变的状态。
 *  外部状态：随环境的改变而改变，不可以共享的状态。
 *
 */
public class FlyWeightPattern {

    public static void main(String[] args) {
        ChessFactory factory = new ChessFactory();
        Chess chess1 ,chess2, chess3, chess4, chess5;
        chess1 = factory.getChess("b");
        chess2 = factory.getChess("b");
        chess3 = factory.getChess("r");
        chess4 = factory.getChess("r");
        chess5 = factory.getChess("r");

        chess1.display("帅", new Location(1,3));
        chess2.display("卒", new Location(13,14));
        chess3.display("帅", new Location(5,20));
        chess4.display("兵", new Location(1,3));
        chess5.display("炮", new Location(4,3));

        System.out.println(chess1 == chess2);
        System.out.println(chess1);
        System.out.println(chess2);

        String name = "hao";
        String h = "hao";
        System.out.println(name == h);
    }
}

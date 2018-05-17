package com.houlong.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 生产象棋工厂
 */
public class ChessFactory {

    //使用hashmap来存储享元对象，充当享元池
    private static Map<String, Chess> chessMap = new HashMap<>();

    public ChessFactory(){
        chessMap.put("b", BlackChess.getInstance());
        chessMap.put("r", RedChess.getInstance());
    }

    public static Chess getChess(String color) {
        if (chessMap.containsKey(color)) {
            return chessMap.get(color);
        } else {
            return chessMap.get(color);
        }
    }
}

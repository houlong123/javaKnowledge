package com.houlong.pattern.memento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原发器
 */
public class Chessman {
    private String name;
    private int x;
    private int y;
    private List<ChessmanMemento> mementoList = new ArrayList<>();
    private Memeto memeto;

    public Chessman(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    //保存状态
    public void save() {
        this.mementoList.add(new ChessmanMemento(this));
    }

    public void restore(int index) {
        ChessmanMemento memento = mementoList.get(index);
        this.name = memento.getName();
        this.y = memento.getY();
        this.x = memento.getX();
    }

    /**
     * 保存状态信息
     * @return
     */
    public Memeto update() {
        return new Memeto(name, x, y);
    }

    public void restore(Memeto memeto) {
        this.name = memeto.getName();
        this.y = memeto.getY();
        this.x = memeto.getX();
    }


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

    public List<ChessmanMemento> getMementoList() {
        return mementoList;
    }

    public void setMementoList(List<ChessmanMemento> mementoList) {
        this.mementoList = mementoList;
    }

    /**
     * 备忘录类
     */
    private class ChessmanMemento {
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

        public ChessmanMemento(Chessman chessman) {
            this.x = chessman.getX();
            this.y = chessman.getY();
            this.name = chessman.getName();


        }
    }
}

package com.houlong.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式之负责人对象，只负责管理备忘录对象，不能对其进行修改
 */
public class MementoCaretaker {
    private List<Memeto> memetoList = new ArrayList<>();

    public Memeto getMemeto(int index) {
        return memetoList.get(index);
    }

    public void setMemeto(Memeto memeto) {
        memetoList.add(memeto);
    }
}

package com.houlong.pattern.iterator;

import java.util.List;

/**
 * 抽象遍历器类
 */
abstract class AbstractIterator {

    public abstract void next();
    public abstract boolean isLast();
    public abstract void previous();
    public abstract Object getNextIterm();
    public abstract Object getPreviousIterm();
    public abstract boolean isFirst();
    public abstract List<Object> getIterms();
}

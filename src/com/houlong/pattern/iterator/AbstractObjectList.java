package com.houlong.pattern.iterator;

import java.util.List;

/**
 * 抽象聚合类
 */
abstract class AbstractObjectList {

    List<Object> list ;
    public AbstractObjectList(List<Object> list) {
        this.list = list;
    }

    public void addObject(Object object) {
        list.add(object);
    }

    public void removeObject(Object object) {
        list.remove(object);
    }

    public List<Object> getObjects() {
        return list;
    }

    abstract  AbstractIterator createIterator();
}

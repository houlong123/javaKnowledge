package com.houlong.pattern.iterator;

import java.util.List;

/**
 * Created by houlong on 2017/6/20.
 */
public class ProduceIterator extends AbstractIterator {

    private ProductList productList;
    private List<Object> products;
    private int cursorNext;
    private int cursorPrevious;

    @Override
    public List<Object> getIterms() {
        return null;
    }

    public ProduceIterator(ProductList list) {
        productList = list;
        products = productList.getObjects();
        cursorNext = 0;
        cursorPrevious = products.size() - 1;
    }

    @Override
    public void next() {
        if (cursorNext < products.size()) {
            cursorNext++;
        }
    }

    @Override
    public boolean isLast() {
        return (cursorNext == products.size());
    }

    @Override
    public void previous() {
        if (cursorPrevious > -1) {
            cursorPrevious--;
        }
    }

    @Override
    public Object getNextIterm() {
        return products.get(cursorNext);
    }

    @Override
    public boolean isFirst() {
        return (cursorPrevious == -1);
    }

    @Override
    public Object getPreviousIterm() {
        return products.get(cursorPrevious);
    }
}

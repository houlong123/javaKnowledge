package com.houlong.pattern.iterator;

import java.util.List;

/**
 * Created by houlong on 2017/6/20.
 */
public class PageIterator extends AbstractIterator {

    private ProductList productList;
    private List<Object> products;
    private int cursorNext;
    //private int cursorPrevious;
    private int pageSize;
    private int pageCount;

    public PageIterator(ProductList productList, int pageSize) {
        this.productList = productList;
        this.products = productList.getObjects();
        this.pageSize = pageSize;
        this.pageCount = products.size()%pageSize == 0 ? products.size()/pageSize : products.size()/pageSize + 1;
        this.cursorNext = 0;
        //this.cursorPrevious = pageCount;
        System.out.println("总页数："+pageCount);
    }
    @Override
    public void next() {
        if (cursorNext < pageCount) {
            cursorNext++;
        }
    }

    @Override
    public boolean isLast() {
        return cursorNext == pageCount;
    }

    @Override
    public void previous() {
        if (cursorNext > 1) {
            cursorNext--;
        }
    }

    @Override
    public List<Object> getNextIterm() {
        return null;
    }

    @Override
    public Object getPreviousIterm() {
        return null;
    }

    @Override
    public List<Object> getIterms() {
        int num = (cursorNext+1)*pageSize;
        if (num > products.size()) {
            num = products.size();
        }
        return products.subList(cursorNext*pageSize, num);

    }

    @Override
    public boolean isFirst() {
        return cursorNext == 1;
    }
}

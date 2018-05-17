package com.houlong.pattern.iterator;

import java.util.List;

/**
 * 具体聚合类
 */
public class ProductList extends AbstractObjectList {

    public ProductList(List<Object> list) {
        super(list);
    }

    @Override
    AbstractIterator createIterator() {
        //return new ProduceIterator(this);
        return new PageIterator(this,2);
    }
}

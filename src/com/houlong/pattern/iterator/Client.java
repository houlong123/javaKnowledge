package com.houlong.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 */
public class Client {

    public static void main(String[] args) {
        List<Object> products = new ArrayList<Object>();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("断肠草");
        products.add("葵花宝典");
        products.add("一指禅");

        AbstractObjectList list;
        AbstractIterator iterator;
        list = new ProductList(products);
        list.addObject("绝世暴打");
        iterator = list.createIterator();
        int flag = 0;
        while (!iterator.isLast()) {
            //System.out.print(iterator.getNextIterm() + ",");
            List<Object> lis = iterator.getIterms();
            for (Object ob : lis) {
                System.out.print(ob + ",");
            }
            System.out.println();
            iterator.next();

            if (flag == 1) {
                System.out.println("反向遍历");
                iterator.previous();
                lis = iterator.getIterms();
                for (Object ob : lis) {
                    System.out.print(ob + ",");
                }
                System.out.println();
                System.out.println("=======================");
            }
            flag++;
        }


        /*System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("逆向遍历");
        while (!iterator.isFirst()) {
            System.out.print(iterator.getPreviousIterm() + ",");
            iterator.previous();
        }*/
    }
}

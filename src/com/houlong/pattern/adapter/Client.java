package com.houlong.pattern.adapter;

/**
 * 适配器模式
 */
public class Client {

    public static void main(String[] args) {
        OperationAdapter adapter = new OperationAdapter();
        int result[];
        int score;
        int[] array = {12,323,4,21,43,53};
        for (int num: array) {
            System.out.println(num);
        }
        System.out.println("=========排序后===========");
        result = adapter.sort(array);
        for (int num: result) {
            System.out.println(num);
        }
        System.out.println("=========查询===========");
        System.out.println(adapter.search(array,212));
    }
}

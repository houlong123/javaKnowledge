package com.houlong.java.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by houlong on 2018/4/16.
 */
public class ParallelStreamTest {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        numbers.parallelStream().forEachOrdered(integer -> {
            if (integer > 5) {
                System.out.println("厉害啦，竟然大于5啦 " + integer);
            } else {
                System.out.println("切，竟然小于5 " + integer);
            }
        });

        try {
            numbers.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

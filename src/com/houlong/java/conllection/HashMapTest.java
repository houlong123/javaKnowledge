package com.houlong.java.conllection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 本类用于测试证明HashMap在多线程环境下是不安全的，会引发死循环
 */
public class HashMapTest extends Thread {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static Map<Integer, Integer> map = new HashMap<>(1);

    public void run() {
        while (ai.get() < 100000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        HashMapTest thread0 = new HashMapTest();
        HashMapTest thread1 = new HashMapTest();
        HashMapTest thread2 = new HashMapTest();
        HashMapTest thread3 = new HashMapTest();
        HashMapTest thread4 = new HashMapTest();

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

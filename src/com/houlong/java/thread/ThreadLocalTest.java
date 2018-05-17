package com.houlong.java.thread;

/**
 * ThreadLocal相关学习
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        for (int index = 0; index < 10; index++) {
            threadLocal.set(index);
            threadLocal.get();
        }
    }
}

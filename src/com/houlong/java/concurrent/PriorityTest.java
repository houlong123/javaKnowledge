package com.houlong.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程优先级
 */
public class PriorityTest {

    private static class SimplePriority implements Runnable {

        private int countDown = 5;
        private volatile double d;
        private int priority;

        public SimplePriority(int priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return Thread.currentThread() + "：" + countDown;
        }

        @Override
        public void run() {
            Thread.currentThread().setPriority(priority);
            while (true) {
                for (int i = 1; i < 100000; i++) {
                    d += (Math.PI + Math.E) / (double) i;
                    if (i % 1000 == 0)
                        Thread.yield();
                }
                System.out.println(this);
                if (--countDown == 0) return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SimplePriority(Thread.MIN_PRIORITY));

        exec.execute(new SimplePriority(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}

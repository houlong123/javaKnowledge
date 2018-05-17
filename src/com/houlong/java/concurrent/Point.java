package com.houlong.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by houlong on 2017/9/19.
 */
public class Point {
    private static double x, y;
    private final static  StampedLock lock = new StampedLock();

    static void move(double deltaX, double deltaY) {
        long stamp = lock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    static void read() {
        long stamp = lock.readLock();
        try {
            System.out.println("read: x = " + x + ", y = " + y);

            move(12, 76);
            //double dd = get();
            //System.out.println("测试StampedLock锁的可重入性：" + dd);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    static double get() {
        long stamp = lock.readLock();
        try {
            double tempX = x;
            double tempY = y;
            return tempX + tempY;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        System.out.println("before: x = " + x + ", y = " + y);

        /*for (int x = 0; x < 100; x++) {
            new Thread(() -> read()).start();
        }*/

        new Thread(() -> read()).start();

       /* for (double x = 0; x < 1; x++) {
            new Thread(() -> move(2, 4)).start();
            try {
                Thread.sleep(TimeUnit.SECONDS.toSeconds(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/



        System.out.println("after: x = " + x + ", y = " + y);
    }
}

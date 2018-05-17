package com.houlong.java.concurrent.forkjoin;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by houlong on 2018/4/15.
 */
public class LockSupportTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "ah");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }

}

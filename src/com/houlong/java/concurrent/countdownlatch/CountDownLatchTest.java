package com.houlong.java.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by houlong on 2017/9/26.
 */
public class CountDownLatchTest {

    private static final int MAX_WORK_DURATION = 5000;    // 最大工作时间
    private static final int MIN_WORK_DURATION = 1000;    // 最小工作时间

    // 产生随机的工作时间
    private static long getRandomWorkDuration(long min, long max) {
        return (long) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) {
        Worker xiaoming = new Worker("小明", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
        Worker feiji = new Worker("飞机", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new WorkerThread(xiaoming, countDownLatch)).start();
        new Thread(new WorkerThread(feiji, countDownLatch)).start();

        try {
            countDownLatch.await();
            System.out.println("All jobs have been finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



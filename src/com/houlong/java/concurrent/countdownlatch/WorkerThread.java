package com.houlong.java.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by houlong on 2017/9/26.
 */
public class WorkerThread implements Runnable {

    private Worker worker;
    private CountDownLatch downLatch;

    public WorkerThread(Worker worker, CountDownLatch downLatch) {
        this.worker = worker;
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        worker.doWork();  //工人工作
        downLatch.countDown(); //工作完成后倒计时次数减一
    }
}

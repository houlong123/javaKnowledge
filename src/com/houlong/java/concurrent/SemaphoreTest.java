package com.houlong.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 信号量Semaphore使用
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = new ThreadPoolExecutor(THREAD_COUNT, 200, 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    /**
     * 10个数据库连接
     */
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int index = 0; index < THREAD_COUNT; index++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("操作数据库");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            });
        }

        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
            //System.out.println("任务执行中，请稍后。。。");
        }

        System.out.println("执行完成");
    }
}

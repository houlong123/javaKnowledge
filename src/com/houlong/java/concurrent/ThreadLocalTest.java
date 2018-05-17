package com.houlong.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by houlong on 2018/4/19.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        AtomicInteger nextId = new AtomicInteger(1);
        ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return nextId.getAndIncrement();
            }
        };

        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int index = 0; index < 10; index++) {
            executorService.execute(()-> System.out.println(threadId.get()));
        }
    }
}

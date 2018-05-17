package com.houlong.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by houlong on 2018/4/12.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        //手动创建线程池
        int processors = Runtime.getRuntime().availableProcessors();
        /**
         * 第一个参数：核心线程池数
         * 第二个参数：最大线程池数
         * 第三个参数：在线程数多余核心线程数的时候，多余线程存活时间
         * 第四个参数：时间单位，s
         * 第五个参数：存放任务的队列
         * 第六个参数：创建线程的工厂方法
         * 第七个参数：饱和策略。4种：
         *                       1. AbortPolicy：直接抛出异常。默认策略
         *                       2. CallerRunsPolicy：用调用者所在的线程来执行任务
         *                       3. DiscardOldestPolicy：丢弃队列中最靠前的任务，并执行当前任务
         *                       4. DiscardPolicy直接丢弃任务
         */
        service = new ThreadPoolExecutor(processors, processors + 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(4), new TestThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int index = 0; index < 20; index++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    String[] array = threadName.split("-");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //if ("5".equals(array[array.length-1]))
                        System.out.println(Thread.currentThread().getName());
                }
            });
        }

        service.shutdown();
    }

    static class TestThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        TestThreadFactory() {
            namePrefix = "testpool-" +
                poolNumber.getAndIncrement() +
                "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r,namePrefix + threadNumber.getAndIncrement());
            return thread;
        }
    }
}

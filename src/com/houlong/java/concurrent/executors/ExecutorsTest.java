package com.houlong.java.concurrent.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executors框架使用
 * @author houlong
 * @version 1.0.0
 */
public class ExecutorsTest {

    /**
     * 继承有返回结果的Callable接口
     */
    static class Task implements Callable<String> {

        private int seed;

        public Task(int seed) {
            this.seed = seed;
        }

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(5);
            return "线程 " + Thread.currentThread().getName() + " 获取种子数： " + seed;
        }
    }


    /**
     * 继承无返回结果的Runnable接口
     */
    static class TestRunnable implements Runnable {
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 手动创建线程池。因为使用Executors创建线程池会有一些弊端：
         *  1）newFixedThreadPool 和 newSingleThreadExecutor
         *  主要问题是堆积的请求队列可能会耗费非常大的内存，甚至OOM
         *
         *  2）newCachedThreadPool 和 newScheduledThreadPool
         *   主要问题是因为默认的线程数量为Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM
         */
        ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 200,0L,
        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        Random random = new Random(10000);
        List<Future> list = new ArrayList<>();

        for (int index = 0; index < 1; index++) {
            Future<String> future = executor.submit(new Task(random.nextInt()));
            list.add(future);
        }

        executor.shutdown();
        for (Future<String> future : list) {
            //在执行的任务继承了有返回值的Callable接口时，在获取结果值之前，需要先判断任务是否已结束，因为在没有判断的时候直接调用get获取结果可能会导致线程睡眠
            while(!future.isDone()) {
                System.out.println("Future返回如果没有完成，则一直循环等待，直到Future返回完成");
            }

            System.out.println(future.get());
        }



        //##########################################   无返回结果实例  ################################################################

        /**
         * 使用Executors创建线程池
         */
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 200; i++){
            executorService.execute(new TestRunnable());
        }

        executorService.shutdown();

        //在执行的任务继承了无返回值的Runnable接口时，如果有要求在所有任务执行完后做一些工作A，则需要在开始工作A之前，需判断当前线程池是否已中断
        while (! executorService.isTerminated()) {
            System.out.println("任务执行中。。。。");
        }
        System.out.println("完成");

    }
}

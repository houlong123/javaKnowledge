package com.houlong.java.concurrent;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier类使用
 *
 * CyclicBarrier为可循环使用的屏障。让一组线程到达屏障时被阻塞，直到最后一个线程到达屏障时，所有被屏障拦截的线程才会继续运行。
 */
public class CyclicBarrierTest implements Runnable {

   /*
   //因为主线程和子线程的调度都有CPU决定，因此两个线程都有可能先执行，所以输入结果可能不一致
   static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);   //构造方法1
    public static void main(String[] args) {
        //子线程
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        //主线程
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }

    */
/*
    //在所有线程都到达屏障时，优先执行构造函数中的第二个参数指定的任务barrierAction
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());  //构造方法2
    public static void main(String[] args) {
        //子线程
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        //主线程
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "_" + 3);
        }
    }
*/


    // CyclicBarrir应用场景
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
    CountDownLatch countDownLatch = new CountDownLatch(4);
    /**
     * 保存每个sheet计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterMap = new ConcurrentHashMap<>(4);
    /**
     * 假如有4个sheet，启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterMap.put(Thread.currentThread().getName(), 1);     //模拟银流计算结果，并保存

                    //银流计算完成，插入一个屏障
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("dddd");
    }

    @Override
    public void run() {
        int sheetCount = 0;
        for (Map.Entry<String, Integer> entry : sheetBankWaterMap.entrySet()) {
            sheetCount += entry.getValue();
        }

        System.out.println("银流数目：" + sheetCount);
    }

    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.count();
    }

}

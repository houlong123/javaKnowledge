package com.houlong.java.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架
 */
public class CountTask  extends RecursiveTask<Integer> {

    private static final int THRESHLD = 2; //阈值
    private int start;
    private int end;
    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (end + start) >>> 1;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle+1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待子任务执行完，并得到结果。注意二者的调用顺序要与fork的相反
            int rightResutl = rightTask.join();
            int leftResult = leftTask.join();


            sum = leftResult + rightResutl;

        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = 0;

        long b = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++) {
            sum +=i;
        }
        System.out.println(">>>" + sum);
        System.out.println("bbb >>>> " + (System.currentTimeMillis() - b));

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，负责技术
        CountTask task = new CountTask(1,10000);
        long a = System.currentTimeMillis();
        Future<Integer> result = forkJoinPool.submit(task);

        try {
            System.out.println(result.get());
            System.out.println("Fork/Join框架 >>>> " + (System.currentTimeMillis() - a));
        } catch (Exception e) {

        }
    }
}

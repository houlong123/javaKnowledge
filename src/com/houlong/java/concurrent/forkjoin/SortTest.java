package com.houlong.java.concurrent.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by houlong on 2017/12/21.
 */
public class SortTest {

    private static int MAX = 1000;

    private static int inits[] = new int[MAX];

    static {
        Random random = new Random();
        for (int i = 0; i < MAX; i++) {
            inits[i] = random.nextInt(1000000);
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int a[] = inits.clone();
        SortTask task  = new SortTask(a);
        System.out.println("排序前：" + Arrays.toString(a));
        pool.submit(task);
        do {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while(!task.isDone());
        System.out.println("排序后：" + Arrays.toString(a));

    }


    // 继承ForkJoinTask的子类RecursiveAction。由于是没有返回，所以需要在获取之前，先判断任务是否已完成，没有完成的话，继续等待
    static class SortTask extends RecursiveAction {

        static final int THRESHOLD = 10;
        final int[] array; final int lo, hi;

        SortTask(int[] array, int lo, int hi) {
            this.array = array; this.lo = lo; this.hi = hi;
        }

        SortTask(int[] array) { this(array, 0, array.length); }

        @Override
        protected void compute() {
            if (hi - lo < THRESHOLD) {
                sortSequentially(lo, hi);
            } else {
                int mid = (lo + hi) >>> 1;
                SortTask right = new SortTask(array, lo, mid);
                SortTask left = new SortTask(array, mid, hi);
                invokeAll(right, left);

                /**
                 * 另一种方式，与invokeAll实现逻辑一样。
                 *
                 * 备注：需要注意的是，join调用顺序要与fork的调用顺序相反。具体原因由源码可知。
                 * 或看博客https://yq.aliyun.com/articles/48736?spm=5176.100239.blogcont48737.8.txj280
                 *
                 * //任务分解
                 *    right.fork();
                 *    left.fork();
                 *
                 *    //任务结果合并
                 *    left.join();
                 *    right.join();
                 */

                merge(lo, mid, hi);
            }
        }

        void sortSequentially(int lo, int hi) {
            Arrays.sort(array, lo, hi);
        }
        void merge(int lo, int mid, int hi) {
            int[] buf = Arrays.copyOfRange(array, lo, mid);
            for (int i = 0, j = lo, k = mid; i < buf.length; j++) {
                array[j] = (k == hi || buf[i] < array[k]) ? buf[i++] : array[k++];
            }

        }
    }
}

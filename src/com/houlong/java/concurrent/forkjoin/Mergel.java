package com.houlong.java.concurrent.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 归并排序
 */
public class Mergel {

    private static int MAX = 10000;

    private static int inits[] = new int[MAX];

    static {
        Random random = new Random();
        for (int i = 0; i < MAX; i++) {
            inits[i] = random.nextInt(1000);
        }
    }

    private static int[] forkMergel(int source[]) {
        int len = source.length;
        if (len > 2) {
            int middleIndex = len >>> 1;
            //拆分数组
            int[] result1 = forkMergel(Arrays.copyOf(source, middleIndex));
            int[] result2 = forkMergel(Arrays.copyOfRange(source, middleIndex, len));

            int mer[] = join(result1, result2);
            return mer;
        } else {
            if (len == 1 || source[0] <= source[1]) {
                return source;
            } else {
                int[] temp = new int[len];
                temp[0] = source[1];
                temp[1] = source[0];
                return temp;
            }
        }
    }

    private static int[] join(int[] array1, int[] array2) {
        int arrayLen1 = array1.length;
        int arrayLen2 = array2.length;
        int[] destArray = new int[arrayLen1 + arrayLen2];
        for (int index = 0, arrayIndex1 = 0, arrayIndex2 = 0; index < arrayLen1 + arrayLen2; index++) {
            //防止数组越界
            int values1 = arrayIndex1 >= arrayLen1 ? Integer.MAX_VALUE : array1[arrayIndex1];
            int values2 = arrayIndex2 >= arrayLen2 ? Integer.MAX_VALUE : array2[arrayIndex2];

            if (values1 < values2) {
                destArray[index] = values1;
                arrayIndex1++;
            } else {
                destArray[index] = values2;
                arrayIndex2++;
            }
        }
        return destArray;
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        int results[] = forkMergel(inits.clone());
        long endTime = System.currentTimeMillis();
        // 如果参与排序的数据非常庞大，记得把这种打印方式去掉
        System.out.println("耗时=" + (endTime - beginTime) /*+ " | " + Arrays.toString(results)*/);

        //Fork/join框架使用
        long beginTime1 = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        MyTask task = new MyTask(inits.clone());
        ForkJoinTask<int[]> joinTask = pool.submit(task);
        try {
            int[] ss = joinTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Fork/Join框架排序，耗时=" + (System.currentTimeMillis() - beginTime1));
    }

    /**
     * Fork/Join并行计算框架
     *
     * RecursiveTask：任务有返回结果
     * RecursiveAction：任务无返回结果
     */
    static class MyTask extends RecursiveTask<int[]> {

        private int[] source;

        public MyTask(int[] source) {
            this.source = source;
        }

        @Override
        protected int[] compute() {
            int len = source.length;
            if (len > 2) {
                int middleIndex = len >>> 1;
                MyTask rigthTask = new MyTask(Arrays.copyOf(source, middleIndex));
                MyTask leftTask = new MyTask(Arrays.copyOfRange(source, middleIndex, len));
                rigthTask.fork();
                leftTask.fork();

                //合并两个集合。调用顺序与fork的调用顺序相反。具体原因由源码可知。
                int[] resultArray2 = leftTask.join();
                int[] resultArray1 = rigthTask.join();
                return Mergel.join(resultArray1, resultArray2);
            } else {
                if (len == 1 || source[0] < source[1]) {
                    return source;
                } else {
                    int[] tempArr = new int[len];
                    tempArr[0] = source[1];
                    tempArr[1] = source[0];
                    return tempArr;
                }
            }
        }
    }
}

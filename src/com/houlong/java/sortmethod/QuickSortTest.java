package com.houlong.java.sortmethod;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * Created by houlong on 2018/4/23.
 */
public class QuickSortTest {

    public static void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = array[left];    //定义基准值为数组第一个数
        int low = left;
        int high = right;

        while (low < high) {
            while (pivot < array[high] && low < high) {     // 从右往左找比基准值小的数
                high--;
            }

            while (pivot >= array[low] && low < high) {      // 从左往右找比基准值大的数
                low++;
            }

            if (low < high) {   //如果low < high，交换位置
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }

        array[left] = array[low];
        array[low] = pivot;     //将基准值放在合适位置

        quickSort(array, left, low - 1);   //对左边子数组进行排序
        quickSort(array, low + 1, right);   //对右边子数组进行排序
    }

    public static void main(String[] args) {
        int[] num = {3, 9, 2, 8, 7};

        quickSort(num, 0, num.length  - 1);

        Arrays.stream(num).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        });


    }
}

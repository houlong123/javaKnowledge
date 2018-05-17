package com.houlong.java.sortmethod;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * Created by houlong on 2018/4/23.
 */
public class BubbleSortTest {

    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int index = 0; index < size - 1; index++) {
            for (int j = 0; j < size - 1 - index; j++) {
                 if (numbers[j] > numbers[j + 1]) {
                     temp = numbers[j];
                     numbers[j] = numbers[j + 1];
                     numbers[j + 1] = temp;
                 }

                Arrays.stream(numbers).forEach(value -> System.out.print(value));
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        int[] num = {3, 9, 2, 8, 7};

        bubbleSort(num);
    }
}

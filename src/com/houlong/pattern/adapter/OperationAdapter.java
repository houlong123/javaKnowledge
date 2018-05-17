package com.houlong.pattern.adapter;

/**
 * 对象适配器
 */
public class OperationAdapter implements ScoreOperation {

    private QuickSort quickSort;
    private BinarySearch search;

    public OperationAdapter() {
        this.quickSort = new QuickSort();
        this.search = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        return quickSort.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return search.binarySearch(array, key);
    }
}

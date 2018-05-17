package com.houlong.pattern.adapter;

/**
 * 目标接口
 */
interface ScoreOperation {
    public int[] sort(int[] array);
    public int search(int[] array, int key);
}

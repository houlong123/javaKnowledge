package com.houlong.pattern.bridge;

/**
 * 苹果操作系统
 */
public class MacOperationSystem implements OperationSystem {

    @Override
    public void doPaint(Matrix m) {
        System.out.print("苹果操作系统展示图片：");
    }
}

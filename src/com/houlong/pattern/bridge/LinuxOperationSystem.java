package com.houlong.pattern.bridge;

/**
 * Linux操作系统
 */
public class LinuxOperationSystem implements OperationSystem {

    @Override
    public void doPaint(Matrix m) {
        System.out.print("Linux操作系统展示图片：");
    }
}

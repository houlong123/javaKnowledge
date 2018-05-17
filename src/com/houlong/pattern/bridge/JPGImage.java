package com.houlong.pattern.bridge;

/**
 * JPG图片
 */
public class JPGImage extends Image {

    @Override
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        operationSystem.doPaint(m);
        System.out.println(fileName + ", 格式为jpg");
    }
}

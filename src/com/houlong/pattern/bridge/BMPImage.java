package com.houlong.pattern.bridge;

/**
 * BMP图片
 */
public class BMPImage extends Image {

    @Override
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        operationSystem.doPaint(m);
        System.out.println(fileName + ", 格式为BMP");
    }
}

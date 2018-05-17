package com.houlong.pattern.bridge;

/**
 * 桥接模式，处理多维度变化
 * 实现模式：将原先的继承关系改为动态组合关系，可以减少类的个数
 */
public class Client {

    public static void main(String[] args) {
        Image image = new JPGImage();
        OperationSystem operationSystem = new MacOperationSystem();
        image.setOperationSystem(operationSystem);
        image.parseFile("小龙女");
    }
}

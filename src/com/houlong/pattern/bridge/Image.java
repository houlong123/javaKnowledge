package com.houlong.pattern.bridge;

/**
 * 图片抽象类
 */
abstract class Image {

    protected OperationSystem operationSystem;

    public void setOperationSystem(OperationSystem operationSystem) {
        this.operationSystem = operationSystem;
    }

    /**
     * 解析文档
     * @param fileName
     */
    public abstract void parseFile(String fileName);
}

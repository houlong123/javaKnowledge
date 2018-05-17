package com.houlong.pattern.FactoryMethod;

/**
 * 具体产品
 */
public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("文件记录日志");
    }
}

package com.houlong.pattern.FactoryMethod;

/**
 * 工厂方法模式
 */
public class Client {

    public static void main(String[] args) {
        Factory factory = new DBFactory();
        Logger logger = factory.createLogger();
        logger.writeLog();
    }

}

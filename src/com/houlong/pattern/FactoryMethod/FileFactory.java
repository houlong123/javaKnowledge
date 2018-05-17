package com.houlong.pattern.FactoryMethod;

/**
 * 具体工厂
 */
public class FileFactory implements Factory {

    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}

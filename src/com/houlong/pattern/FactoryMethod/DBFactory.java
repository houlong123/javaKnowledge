package com.houlong.pattern.FactoryMethod;

/**
 * 具体工厂
 */
public class DBFactory implements Factory {

    @Override
    public Logger createLogger() {
       // return new DbLogger();
        return null;
    }
}

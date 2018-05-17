package com.houlong.pattern.FactoryMethod;

/**
 * 具体产品
 */
public class DbLogger implements Logger {

    private DbLogger(){}

    //使用匿名类
    public static Factory factory = new Factory() {
        @Override
        public Logger createLogger() {
            return new DbLogger();
        }
    };

    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}

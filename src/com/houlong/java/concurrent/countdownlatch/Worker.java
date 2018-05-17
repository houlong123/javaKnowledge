package com.houlong.java.concurrent.countdownlatch;

/**
 * Created by houlong on 2017/9/26.
 */
public class Worker {

    private String name; //姓名
    private long workDuration; //工作持续时间

    public Worker(String name, long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }

    public void doWork(){
        System.out.println(name + " begins to work....");
        try {
            Thread.sleep(workDuration);  //模拟工作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " has finished the jobs...");
    }
}

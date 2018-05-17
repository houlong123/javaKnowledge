package com.houlong.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式,实现对象克隆
 */
public class Client {

    public static void main(String[] args) throws Exception {
        WeeklyLog weeklyLog = new WeeklyLog();
        List<String> devices = new ArrayList<>();
        devices.add("mac pro");
        devices.add("phone");
        devices.add("pen");
        weeklyLog.setContent("广中医图书馆");
        weeklyLog.setDate("2017-06-11");
        weeklyLog.setName("原型模式");
        weeklyLog.setDevices(devices);
        System.out.println(weeklyLog.toString());

        WeeklyLog weeklyLog1 = weeklyLog.clone();
        System.out.println("=====================");
        System.out.println( weeklyLog == weeklyLog1);
        weeklyLog1.setName("创建者模式");
        System.out.println(weeklyLog1.toString());
        System.out.println("引用对象浅克隆:");
        System.out.println(weeklyLog.getDevices() == weeklyLog1.getDevices());

        WeeklyLog weeklyLog2 = weeklyLog.deepClone();
        System.out.println(weeklyLog2.toString());
        System.out.println("引用对象深克隆:");
        System.out.println(weeklyLog.getDevices() == weeklyLog2.getDevices());

    }
}

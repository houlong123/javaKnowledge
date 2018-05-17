package com.houlong.pattern.composite;

/**
 * 叶子构件：财务部
 */
public class FinanceDepartment extends Organization {

    @Override
    public void notice() {
        System.out.println("财务部发送通知");
    }
}

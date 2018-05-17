package com.houlong.pattern.composite;

/**
 * 叶子构件。研发部门
 */
public class RDDepartment extends Organization {

    @Override
    public void notice() {
        System.out.println("研发部门发送通知");
    }
}

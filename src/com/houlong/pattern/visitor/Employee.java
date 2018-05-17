package com.houlong.pattern.visitor;

/**
 * 抽象元素类(员工类)
 */
abstract class Employee {
    //接受一个抽象访问者访问
    public abstract void accept(Department handler);
}

package com.houlong.pattern.state;

/**
 * 抽象状态类。
 * 声明了各种不同状态对应的方法。
 */
abstract class AccountState {
    protected Account acc;

    abstract void deposit(int amount);  //存款
    abstract void withdraw(int amount); //取款
    abstract void computeInterest(); //计算利息
    abstract void stateCheck(); //状态监测
}

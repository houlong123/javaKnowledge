package com.houlong.pattern.state;

/**
 * 状态模式
 */
public class StatePattern {

    public static void main(String[] args) {
        Account account = new Account("侯龙", 0);
        account.deposit(1000);
        account.computeInterest();
        account.withdraw(500);
        account.withdraw(2500);
        account.computeInterest();
        account.withdraw(100);
        account.computeInterest();
        account.deposit(1000);

    }
}

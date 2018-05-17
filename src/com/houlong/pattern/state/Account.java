package com.houlong.pattern.state;

/**
 * 环境类。拥有多种状态的对象。
 * 由于环境类的状态存在多样性，且不同状态下对象的的行为有所不同，因此将状态独立出去形成单独的状态类
 */
public class Account {

    private AccountState state;     //状态类
    private String owner;   //账户名称
    private int balance = 0; //账户余额

    public Account(String owner, int init) {
        this.owner = owner;
        this.balance = init;
        this.state = new NormalState(this);

        System.out.println(this.owner +"开户初始化，余额为：" + this.balance);
        System.out.println("--------------------------------------------");
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void deposit(int amount) {
        System.out.println(this.owner + "存款" + amount);
        state.deposit(amount);
        System.out.println("用户存款后，现总金额为：" + this.balance);
        System.out.println("用户账户状态为:" + this.state.getClass().getName());
        System.out.println("-----------------------------------------------");
    }

    public void withdraw(int amount) {
        System.out.println(this.owner + "取款" + amount);
        state.withdraw(amount);
        System.out.println("用户取款后，现总金额为：" + this.balance);
        System.out.println("用户账户状态为:" + this.state.getClass().getName());
        System.out.println("-----------------------------------------------");
    }

    public void computeInterest() {
        state.computeInterest();
    }
}

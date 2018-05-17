package com.houlong.pattern.state;

/**
 * 受限状态
 */
public class RestrictedState extends AccountState {

    public RestrictedState(AccountState state) {
        this.acc = state.acc;
    }

    void stateCheck() {
        if (acc.getBalance() > -2000 && acc.getBalance() <= 0) {
            acc.setState(new OverdraftState(this));
        } else if (acc.getBalance() > 0) {
            acc.setState(new NormalState(this));
        }
    }

    void deposit(int amount) {
        acc.setBalance(acc.getBalance() + amount);
        stateCheck();
    }

    void withdraw(int amount) {
        System.out.println("账号受限，取款失败！");
    }

    void computeInterest() {
        System.out.println("计算利息！");
    }
}

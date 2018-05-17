package com.houlong.pattern.state;

/**
 * 透支状态
 */
public class OverdraftState extends AccountState {

    public OverdraftState(AccountState state) {
        this.acc = state.acc;
    }

    void stateCheck() {
        if (acc.getBalance() > 0) {
            acc.setState(new NormalState(this));
        } else if (acc.getBalance() == -2000){
            acc.setState(new RestrictedState(this));
        } else if (acc.getBalance() < -2000) {

        }
    }

    void deposit(int amount) {
        acc.setBalance(acc.getBalance() + amount);
        stateCheck();
    }

    void withdraw(int amount) {
        acc.setBalance(acc.getBalance() - amount);
        stateCheck();
    }

    void computeInterest() {
        System.out.println("计算利息！");
    }
}

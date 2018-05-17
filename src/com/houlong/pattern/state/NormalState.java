package com.houlong.pattern.state;

/**
 * 正常状态
 */
public class NormalState extends AccountState  {

    public NormalState(Account acc) {
        this.acc = acc;
    }

    public NormalState(AccountState state) {
        this.acc = state.acc;
    }

    void stateCheck() {
        if (acc.getBalance() > -2000 && acc.getBalance() <= 0) {
            acc.setState(new OverdraftState(this));
        } else if (acc.getBalance() == -2000) {
            acc.setState(new RestrictedState(this));
        } else if (acc.getBalance() < -2000){
            System.out.println("操作受限！");
        }
    }

    void deposit(int amount) {
        this.acc.setBalance(acc.getBalance() + amount);
        stateCheck();
    }

    void withdraw(int amount) {
        this.acc.setBalance(acc.getBalance() - amount);
        stateCheck();
    }

    void computeInterest() {
        System.out.println("正常状态，无须支付利息！");
    }
}

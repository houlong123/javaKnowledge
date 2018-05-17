package com.houlong.pattern.templatemethod;

/**
 *
 * 模板方法模式变体
 */
public class Account {

    /**
     * 账号验证。钩子方法，决定某方法是否执行
     * @param account
     * @param password
     * @return
     */
    public boolean validate(String account, String password) {
        System.out.println("账号：" + account + ">>>>>>> 密码：" + password);
        if ("天下无贼".equals(account) && "123456".equals(password))
            return true;
        return false;
    }

    public void disPlay() {
        System.out.println("显示利息！");
    }

    public void handle(String accout, String password, CalculateInterestCallBack callBack) {
        if (!validate(accout, password)) {
            System.out.println("账号或密码错误");
            return;
        }
        callBack.calculateInterest();
        disPlay();
    }
}

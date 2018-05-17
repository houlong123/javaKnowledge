package com.houlong.pattern.proxy;

/**
 * 代理对象
 */
public class UserDaoProxy extends UserDao {

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("增加新功能1");
        userDao.save();
        System.out.println("保存成功了");
    }
}

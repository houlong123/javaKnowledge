package com.houlong.pattern.proxy;

/**
 * 目标对象
 */
public class UserDaoImpl extends UserDao {
    @Override
    public void save() {
        System.out.println("------保存数据-------");
    }
}

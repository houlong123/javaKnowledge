package com.houlong.pattern.proxy;

/**
 * 代理模式
 */
public class Client {

    public static void main(String[] args) {

         //静态代理：目标对象和代理对象都有继承一个公共父类(接口，抽象类，基础类都OK)
         UserDaoProxy proxy = new UserDaoProxy(new UserDaoImpl());
         proxy.save();


        /*//动态代理
        UserDao userDao = new UserDaoImpl();
        System.out.println("============原型类型：" + userDao.getClass());
        ProxyFactory factory = new ProxyFactory(userDao);
        UserDao proxyUser = (UserDao)factory.getProxyInstance();
        System.out.println("===========代理类型："+ proxyUser.getClass());
        proxyUser.save();*/

        /*
        Cglib代理：目标对象和代理对象都无需要求实现任何的接口
        Animal userDao = new Animal();
        Animal proxy = (Animal) new ProxyCglibFactory(userDao).getProxyInstance();
        proxy.eat();
        */
    }
}

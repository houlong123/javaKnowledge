/*
package com.houlong.pattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

*/
/**
 * Cglib 代理
 *//*

public class ProxyCglibFactory implements MethodInterceptor {

    private Object target;
    public ProxyCglibFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("吃草前：清洗一下");
        Object returnValue = method.invoke(target, args);
        System.out.println("吃草后，刷个牙");
        return returnValue;
    }
}
*/

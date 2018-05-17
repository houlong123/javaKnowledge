package com.houlong.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by houlong on 2017/6/16.
 */
public class ProxyFactory {
    //维护一个目标对象
    private Object object;
    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事物1");
                //执行目标对象方法
                Object returnValue = method.invoke(object, args);
                System.out.println("提交事物1");
                return returnValue;
            }
        });
    }
}

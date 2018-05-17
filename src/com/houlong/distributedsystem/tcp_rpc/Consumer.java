package com.houlong.distributedsystem.tcp_rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 基于TCP协议的RPC实例
 *
 * 服务调用方
 */
public class Consumer {

    public static void main(String[] args) throws NoSuchMethodException, IOException, ClassNotFoundException {
        //接口名称
        String interfacename = SayHelloService.class.getName();
        //需要远程执行的方法
        Method method = SayHelloService.class.getMethod("sayHello", String.class);
        //需要传递的远程参数
        Object[] arguments = {"nn"};
        Socket socket = new Socket("127.0.0.1", 8001);

        //将方法名和参数传递到远程服务提供发
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeUTF(interfacename);
        outputStream.writeUTF(method.getName());
        outputStream.writeObject(method.getParameterTypes());
        outputStream.writeObject(arguments);


        //从远程服务提供发获取执行结果
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Object result = inputStream.readObject();
        System.out.println(result);
    }

}

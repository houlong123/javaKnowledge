package com.houlong.distributedsystem.tcp_rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于TCP协议的RPC实例
 *
 * 服务提供方
 */
public class Provider {

    static Map<String, Object> services = new HashMap<>();
    static {
        services.put("SayHelloService", new SayHelloServiceImpl());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ServerSocket server = new ServerSocket(8001);
        while (true) {
            Socket socket = server.accept();

            //读取服务信息
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String interfacename = inputStream.readUTF();
            String methodname = inputStream.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
            Object[] arguments = (Object[]) inputStream.readObject();

            //执行调用
            Class serviceinterfaceclass = Class.forName(interfacename);
            //取得服务实现对象
            Object service = services.get(interfacename);
            //获取要调用的方法
            Method method = serviceinterfaceclass.getMethod(methodname, parameterTypes);
            Object result = method.invoke(service, arguments);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
        }
    }
}

package com.houlong.distributedsystem.tcp_rpc;

/**
 * 基于TCP协议的RPC实例  服务远程实现
 *
 * @author houlong
 */
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String name) {
        String hello = "hello";
        if (hello.equalsIgnoreCase(name)) {
            return "hello";
        } else {
            return "bye";
        }
    }
}

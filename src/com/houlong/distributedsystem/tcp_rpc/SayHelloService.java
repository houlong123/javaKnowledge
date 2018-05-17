package com.houlong.distributedsystem.tcp_rpc;

/**
 * 基于TCP协议的RPC实例  服务接口
 *
 * @author houlong
 */
public interface SayHelloService {

    public String sayHello(String name);
}

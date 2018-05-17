package com.houlong.pattern.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 单例类（负载均衡器）
 */
public class LoadBalancer {

    //私有静态成员变量，存储唯一实例
    private static volatile LoadBalancer instance = null;
    //服务器集合
    private List<String> serverList = null;

    private LoadBalancer() {
        serverList = new ArrayList<>();
    }

    //使用懒汉式单例模式，使用了"双重检查锁定"
    public static LoadBalancer getInstance() {
        if (instance == null) {
            synchronized (LoadBalancer.class) {
                if (instance == null) {
                    instance = new LoadBalancer();
                }
            }
        }
        return instance;
    }

    public void addServe(String server) {
        serverList.add(server);
    }

    public boolean removeServer(String server) {
        return serverList.remove(server);
    }

    /**
     * 随机获取服务器
     * @return
     */
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return serverList.get(i);
    }

}

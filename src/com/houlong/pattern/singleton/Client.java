package com.houlong.pattern.singleton;

/**
 * 单例模式
 */
public class Client {

    public static void main(String[] args) {
        //创建四个LoadBalancer对象
        LoadBalancer loadBalancer, loadBalancer1, loadBalancer2, loadBalancer3;
        loadBalancer = LoadBalancer.getInstance();
        loadBalancer1 = LoadBalancer.getInstance();
        loadBalancer2 = LoadBalancer.getInstance();
        loadBalancer3 = LoadBalancer.getInstance();

        if (loadBalancer == loadBalancer1 && loadBalancer1 == loadBalancer2 && loadBalancer2 == loadBalancer3) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }

        //添加服务器
        loadBalancer.addServe("server 1");
        loadBalancer.addServe("server 2");
        loadBalancer.addServe("server 3");
        loadBalancer.addServe("server 4");

        //模拟客户端请求的分发
        for(int index = 0; index < 10; index++) {
            String server = loadBalancer.getServer();
            System.out.println("分发请求至服务器：" + server);
        }
    }
}

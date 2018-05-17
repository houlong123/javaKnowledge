package com.houlong.distributedsystem.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * zookeeper客户端
 */
public class TestMainClient implements Watcher {

    protected static ZooKeeper zooKeeper = null;
    protected static Integer mutex;
    int sessionTimeout = 10000;
    protected String root;

    public TestMainClient(String connectionString) {
        if (zooKeeper == null) {
            try {

                System.out.println("新建一个连接：");
                zooKeeper = new ZooKeeper(connectionString, sessionTimeout, this);
                mutex = new Integer(-1);
            } catch (IOException e) {
                zooKeeper = null;
            }
        }
    }

    /**
     * 接收监控，在Zookeeper服务器上的节点发送变化时，接收通知
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        synchronized (mutex) {
            mutex.notify();
        }
    }
}

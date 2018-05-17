package com.houlong.distributedsystem.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 分布式锁实现
 */
public class Locks extends TestMainClient {

    String myZnode;

    public Locks(String connectionString, String root) {
        super(connectionString);
        this.root = root;

        if (zooKeeper != null) {
            try {
                Stat stat = zooKeeper.exists(root, false);

                //创建
                if (stat == null) {
                    zooKeeper.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                }

            } catch (KeeperException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void check() throws KeeperException, InterruptedException {
        //创建临时节点
        myZnode = zooKeeper.create(root + "/lock_", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        getLock();
    }

    void getLock() throws  KeeperException, InterruptedException {
        //获取锁根节点下所有子节点
        List<String> list = zooKeeper.getChildren(root, false);
        if (null != list && list.size() > 0) {
            String[] nodes = list.toArray(new String[list.size()]);
            Arrays.sort(nodes);

            System.out.println("所有子节点：" + nodes.length);
            if (myZnode.equals(root + "/" + nodes[0])) {
                //获取锁
                doAction(myZnode);
            } else {
                waitForLock(nodes[0]);
            }
        }
    }

    private void waitForLock(String node) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(root + "/" + node, true);
        if (stat != null) {
            synchronized(mutex) {
                mutex.wait();
            }
        } else {
            getLock();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
            System.out.println("监听到节点删除");
            super.process(watchedEvent);
            doAction(watchedEvent.getPath());
        }

    }

    /**
     * 获取锁后，执行相关操作
     */
    private void doAction(String path) {
        System.out.println("同步队列已经得到同步，可以开始执行后面的任务了" + path);
        /*try {
            zooKeeper.delete(root + "/" + myZnode, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }*/
    }

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        String connectionString = "localhost:2181";

        Locks locks = new Locks(connectionString, "/locks");


        try {
            locks.check();
        } catch (KeeperException e) {
            System.out.println("失败啦" + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("失败了" + e.getMessage());
        }

    }
}

package com.houlong.distributedsystem;

import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 模拟实现一致性哈希算法
 */
public class ConsistencyHash {

    //节点
    private static TreeMap<Long, Object> nodes = null;
    //真实服务器节点信息
    private static List<String> shards = new ArrayList<>();
    //虚拟节点个数
    private static final int VIRTUAL_NUM = 4;

    //初始化真实服务器节点信息
    static {
        shards.add("192.168.0.0-服务器0");
        shards.add("192.168.0.1-服务器1");
        shards.add("192.168.0.2-服务器2");
        shards.add("192.168.0.3-服务器3");
        shards.add("192.168.0.4-服务器4");

        nodes = new TreeMap<>();
        for (int i=0; i<shards.size(); i++) {
            String shard = shards.get(i);
            for (int index = 0; index < VIRTUAL_NUM; index++) {
                nodes.put(hash(computeMd5("SHARD-" + i + "-NODE-" + index), index), shard);
            }
        }

        System.out.println("================  节点信息  ======================");
        for (Map.Entry entry : nodes.entrySet()) {
            System.out.println("hash值：" + entry.getKey() + "    服务器信息：" + entry.getValue());
        }
        System.out.println("================  节点信息  ======================");
    }

    /**
     * 根据2^32把节点分布到圆环上面。
     * @param digest
     * @param nTime
     * @return
     */
    public static long hash(byte[] digest, int nTime) {
        long rv = ((long) (digest[3+nTime*4] & 0xFF) << 24)
                | ((long) (digest[2+nTime*4] & 0xFF) << 16)
                | ((long) (digest[1+nTime*4] & 0xFF) << 8)
                | (digest[0+nTime*4] & 0xFF);

        return rv & 0xffffffffL;
    }

    /**
     * Get the md5 of the given key.
     * 计算MD5值
     */
    public static byte[] computeMd5(String key) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.reset();
        byte[] keyBytes = null;
        try {
            keyBytes = key.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        md5.update(keyBytes);
        return md5.digest();
    }

    public Object getShard(Long hash) {
        Long key = hash;
        //返回map中map键大于指定值的子map
        SortedMap<Long, Object> tailMap = nodes.tailMap(key);

        if (tailMap.isEmpty()) {
            key = nodes.firstKey();
        } else {
            key = tailMap.firstKey();
        }
        return nodes.get(key);
    }

    public static void main(String[] args) {
        ConsistencyHash hash = new ConsistencyHash();
        for (int index = 0; index < 10; index++) {
            System.out.println("数据： " + index + "  映射到服务器：" + hash.getShard(hash(computeMd5(Integer.toString(index)), new Random().nextInt(VIRTUAL_NUM))));
        }
    }

}

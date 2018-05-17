package com.houlong.java.gc;

import java.util.concurrent.TimeUnit;

/**
 * 如何判断对象不可用？
 *
 * 判断方法1：引用计数算法。即：给对象中添加一个引用计数器，每当有一个地方引用它时，
 * 计数器加1；每当引用失效时，计数器减1；任何时刻计数器为0的对象就是不可能在被使用的。
 *
 * 问题：难以解决对象之间循环引用问题
 *
 * JVM不是使用该算法
 *
 *
 * 判断方法2：可达性分析算法。即：通过一系列称为 GC Roots 的对象作为起始点，从这些节点开始向下搜索，
 * 搜索所走过的路径称为引用链，当一个对象到 GC Roots没有任何引用链相连时（即对象不可达），则证明该对象是不可用的。
 *
 * GC Roots 的对象包括：
 *   1. 虚拟机栈中引用的对象
 *   2. 方法区中类静态属性引用的对象
 *   3. 方法区中常量引用的对象
 *   4. 本地方法栈中引用的对象
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    //只是占有内存作用，看GC日志中是否被回收
    private byte[] bigSize = new byte[_1MB];

    public static void main(String[] args) {
        ReferenceCountingGC testA = new ReferenceCountingGC();
        ReferenceCountingGC testB = new ReferenceCountingGC();


        //相互引用
        testA.instance = testB;
        testB.instance = testA;

        //对象置空，用于垃圾回收
        testA = null;
        testB = null;

        System.gc();

    }
}

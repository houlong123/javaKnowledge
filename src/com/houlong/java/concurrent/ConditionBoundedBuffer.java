package com.houlong.java.concurrent;


import net.jcip.annotations.GuardedBy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显式条件的有界缓存
 */
public class ConditionBoundedBuffer<T> {

    protected final Lock lock = new ReentrantLock();

    //条件谓词：notFull (count < items.length)
    private final Condition notFull = lock.newCondition();

    //条件谓词：notEmpty (count > 0)
    private final Condition notEmpty = lock.newCondition();

    @GuardedBy("lock")
    private final T[] items = (T[]) new Object[10];
    @GuardedBy("lock")
    private int tail, head, conut;

    //阻塞并直到：notFull
    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            while (conut == items.length)
                notFull.await();

            items[tail] = x;
            if (++tail == items.length)
                tail = 0;
            ++conut;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    //阻塞并直到：notEmpty
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (conut == 0)
                notEmpty.await();

            T x = items[head];
            items[head] = null;
            if (++head == items.length)
                head = 0;
            --conut;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionBoundedBuffer<String> buffer = new ConditionBoundedBuffer<>();
        while (true) {
            //生产者线程
            new Thread(()-> {

                try {
                    buffer.put(new StringBuffer().append(Thread.currentThread().getId()).append("_").append(System.currentTimeMillis()).toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


            //消费者线程
            new Thread(()-> {
                    try {
                        System.out.println(Thread.currentThread().getId() + ": " + buffer.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }).start();
        }

    }
}

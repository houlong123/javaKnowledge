package com.houlong.java.thread;

/**
 * Created by houlong on 2017/10/24.
 */
public class Synchronized {

    public synchronized void m() {
        System.out.println("");
    }


    public static void main(String[] args) {

        /*//对Synchronized对象进行加锁
        synchronized (Synchronized.class) {

        }*/

        System.out.println("d");
        //静态同步方法，对Synchronized对象进行加锁
        //m();
    }




}

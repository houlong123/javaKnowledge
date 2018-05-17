package com.houlong.java.thread;

/**
 * Daemon 线程被用作完成支持性工作，但是在Java虚拟机退出时Daemon线程中的finally块并不一定会被执行
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(10);   //模拟长时间的工作
            } catch (InterruptedException e) {
                System.out.println("Error");
            }  finally {
                System.out.println("DaemonThread finally run");
            }

        }
    }
}

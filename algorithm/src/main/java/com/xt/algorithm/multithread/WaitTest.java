/**
 * $Id: WaitTest.java,v 1.0 2019/2/28 11:03 AM wangxiaoteng
 *
 * @Copyright (c) 2019/2/28, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 事件/通知机制
 *
 * @author wangxiaoteng
 * @version $Id: WaitTest.java,v 1.0 2019/2/28 11:03 AM wangxiaoteng
 * @date 2019/2/28 下午11:03 AM
 */
public class WaitTest {

    private static boolean flag = true;

    private static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new WaitThread(), "WaitThread");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new NotifyThread(), "NotifyThread");
        notifyThread.start();
    }

    static class WaitThread implements Runnable {

        @Override
        public void run() {
            //加锁，拥有lock的监视锁
            synchronized (lock) {
                if (flag) {
                    //当条件不满足时，继续wait，同时释放lock的锁
                    System.out.println(Thread.currentThread() + " flag is true . wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class NotifyThread implements Runnable {

        @Override
        public void run() {
            //加锁，拥有lock的监视锁
            synchronized (lock) {
                //获取lock的锁，然后进行通知，通知时不会释放lock的锁
                //直到当前线程释放了lock的锁，其他线程才能从wait()方法中返回
                System.out.println(Thread.currentThread() + " hold lock .notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again.sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
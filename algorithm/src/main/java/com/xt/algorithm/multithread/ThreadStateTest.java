/**
 * $Id: ThreadStateTest.java,v 1.0 2019/2/26 4:06 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/26, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态测试
 *
 * @author wangxiaoteng
 * @version $Id: ThreadStateTest.java,v 1.0 2019/2/26 4:06 PM wangxiaoteng
 * @date 2019/2/26 下午4:06 PM
 */
public class ThreadStateTest {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();
    }

    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Blocked.class) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

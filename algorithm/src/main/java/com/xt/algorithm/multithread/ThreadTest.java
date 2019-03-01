/**
 * $Id: ThreadTest.java,v 1.0 2019/2/19 2:36 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/19, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

/**
 * 线程test
 *
 * @author wangxiaoteng
 * @version $Id: ThreadTest.java,v 1.0 2019/2/19 2:36 PM wangxiaoteng
 * @date 2019/2/19 下午2:36 PM
 */
public class ThreadTest {

    private int i = 10;

    private Object object = new Object();

    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        SleepTestThread sleepTestThread = threadTest.new SleepTestThread();
        SleepTestThread sleepTestThread2 = threadTest.new SleepTestThread();
        new Thread(sleepTestThread).start();
        new Thread(sleepTestThread2).start();

    }

    /**
     * 说明sleep方法虽然交出了CPU的执行权限，但是依然保留对对象的锁，并没有释放锁
     */
    class SleepTestThread implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:" + i);
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态...");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束...");
                i++;
                System.out.println("i:" + i);
            }
        }
    }
}

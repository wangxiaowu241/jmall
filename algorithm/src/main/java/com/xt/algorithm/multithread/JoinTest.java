/**
 * $Id: JoinTest.java,v 1.0 2019/2/28 2:56 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/28, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

/**
 * Thread.join()方法测试
 *
 * @author wangxiaoteng
 * @version $Id: JoinTest.java,v 1.0 2019/2/28 2:56 PM wangxiaoteng
 * @date 2019/2/28 下午2:56 PM
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread joinThread = new Thread(new JoinThread(previous), String.valueOf(i));
            joinThread.start();
            previous=joinThread;
        }
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " terminate...");

    }


    static class JoinThread implements Runnable {

        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate...");
        }
    }
}

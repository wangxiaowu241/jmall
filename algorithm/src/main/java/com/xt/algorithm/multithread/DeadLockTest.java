/**
 * $Id: DeadLockTest.java,v 1.0 2019/3/14 9:12 PM
 *
 * @Copyright (c) 2019/3/14, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

/**
 * 类注释，描述
 *
 * @author
 * @version $Id: DeadLockTest.java,v 1.0 2019/3/14 9:12 PM
 * @date 2019/3/14 下午9:12 PM
 */
public class DeadLockTest {

    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("threadA has lock a");
                        Thread.sleep(1000L);
                        synchronized (b) {
                            System.out.println("threadA-lock b");
                        }
                    } catch (Exception e) {
                        //
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    try {
                        System.out.println("threadB-lock b");
                        Thread.sleep(1000L);
                        synchronized (a) {
                            System.out.println("threadB-lock a");
                        }
                    } catch (Exception e) {
                        //
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}

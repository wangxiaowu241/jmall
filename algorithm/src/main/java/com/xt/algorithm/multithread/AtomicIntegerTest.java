/**
 * $Id: AtomicIntegerTest.java,v 1.0 2019/2/21 11:26 AM wangxiaoteng
 *
 * @Copyright (c) 2019/2/21, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类注释，描述
 *
 * @author wangxiaoteng
 * @version $Id: AtomicIntegerTest.java,v 1.0 2019/2/21 11:26 AM wangxiaoteng
 * @date 2019/2/21 下午11:26 AM
 */
public class AtomicIntegerTest {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private int i = 0;

    public static void main(String[] args) {

        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();

        for (int i = 0; i < 1; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicIntegerTest.safeAutoIncrease();
                    atomicIntegerTest.increase();
                }
            }).start();
        }


        System.out.println("safeAutoIncrease:"+atomicIntegerTest.atomicInteger.get());
        System.out.println("increase:"+atomicIntegerTest.i);
    }

    private void safeAutoIncrease() {
        for (; ; ) {
            int ai = atomicInteger.get();
            boolean result = atomicInteger.compareAndSet(ai, ++ai);
            if (result) {
                break;
            }

        }
    }

    private void increase() {
        i++;
    }

}

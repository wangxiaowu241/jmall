package com.xt.algorithm.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch test
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" running...");
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName()+" running    1111111...");
                }
            },"Thread-" + i).start();
        }
        countDownLatch.await();
        System.out.println("end ...");
    }
}

/**
 * $Id: AQSTest.java,v 1.0 2019/2/20 11:21 AM wangxiaoteng
 *
 * @Copyright (c) 2019/2/20, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * AQS test -
 *
 * @author wangxiaoteng
 * @version $Id: AQSTest.java,v 1.0 2019/2/20 11:21 AM wangxiaoteng
 * @date 2019/2/20 下午11:21 AM
 */
public class AQSTest {


    public static void main(String[] args) throws InterruptedException {

        AQSTest aqsTest = new AQSTest();

        Sync sync = aqsTest.new Sync();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    sync.lock();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sync.unlock();
                }
            });
            thread.start();
        }


    }

    class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }

        @Override
        protected boolean tryAcquire(int arg) {

            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return compareAndSetState(1, 0);
        }

        public boolean tryLock() {
            return tryAcquire(1);
        }

        public boolean tryLock(int arg, long waitTimeNanos) throws InterruptedException {
            return tryAcquireNanos(1, waitTimeNanos);
        }

        public void lock() {
            for (; ; ) {
                if (tryAcquire(1)) {
                    System.out.println("当前线程" + Thread.currentThread().getName() + "开启了锁");
                    break;
                }
            }
        }

        public void unlock() {
            for (; ; ) {
                if (tryRelease(1)) {
                    System.out.println("当前线程" + Thread.currentThread().getName() + "释放了锁");
                    break;
                }
            }
        }
    }
}

/**
 * $Id: TwinsLockTest.java,v 1.0 2019/3/1 4:14 PM wangxiaoteng
 *
 * @Copyright (c) 2019/3/1, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 自定义同步组件，同一时刻，至多只允许两个线程同时访问
 *
 * @author wangxiaoteng
 * @version $Id: TwinsLockTest.java,v 1.0 2019/3/1 4:14 PM wangxiaoteng
 * @date 2019/3/1 下午4:14 PM
 */
public class TwinsLockTest {

    public static void main(String[] args) {


        TwinsLock lock = new TwinsLock();

        for (int i = 0; i <10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        TimeUnit.MILLISECONDS.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+" "+System.currentTimeMillis());
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }, "Thread" + String.valueOf(i)).start();
        }


    }

    static class TwinsLock {

        private Sync sync = new Sync(2);

        public void lock() {
            sync.acquireShared(1);
        }

        public void unlock() {
            sync.releaseShared(1);
        }

        static class Sync extends AbstractQueuedSynchronizer {

            public Sync(int state) {

                if (state <= 0) {
                    throw new IllegalMonitorStateException("init state must larger than zero");
                }
                setState(state);
            }

            @Override
            protected int tryAcquireShared(int reduceCount) {

                for (; ; ) {
                    int currentState = getState();
                    int newCount = currentState - reduceCount;
                    if (newCount < 0 || compareAndSetState(currentState, newCount)) {
                        return newCount;
                    }
                }
            }

            @Override
            protected boolean tryReleaseShared(int returnCount) {
                for (; ; ) {
                    int currentState = getState();
                    int newCount = currentState + returnCount;
                    if (compareAndSetState(currentState, newCount)) {
                        return true;
                    }
                }
            }
        }
    }
}

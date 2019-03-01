/**
 * $Id: MutexTest.java,v 1.0 2019/3/1 11:27 AM wangxiaoteng
 *
 * @Copyright (c) 2019/3/1, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * AQS test
 *
 * @author wangxiaoteng
 * @version $Id: MutexTest.java,v 1.0 2019/3/1 11:27 AM wangxiaoteng
 * @date 2019/3/1 下午11:27 AM
 */
public class MutexTest {

    public static void main(String[] args) {

    }


    static class Mutex {

        private Sync sync = new Sync();

        public void lock() {
            sync.acquire(1);
        }

        public boolean tryLock() {
            return sync.tryAcquire(1);
        }

        public void unLock() {
            sync.release(1);
        }

        public boolean tryUnLock() {
            return sync.tryRelease(1);
        }

        static class Sync extends AbstractQueuedSynchronizer {

            @Override
            protected boolean isHeldExclusively() {
                return getState() == 1;
            }

            @Override
            protected boolean tryAcquire(int arg) {
                assert arg == 1;
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            }

            @Override
            protected boolean tryRelease(int arg) {
                if (getState() == 0) {
                    throw new IllegalMonitorStateException();
                }
                setExclusiveOwnerThread(null);
                setState(0);
                return true;
            }
        }
    }


}

/**
 * $Id: ReadWriteLockTest.java,v 1.0 2019/3/6 9:57 AM wangxiaoteng
 *
 * @Copyright (c) 2019/3/6, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的简单使用
 *
 * @author wangxiaoteng
 * @version $Id: ReadWriteLockTest.java,v 1.0 2019/3/6 9:57 AM wangxiaoteng
 * @date 2019/3/6 下午9:57 AM
 */
public class ReadWriteLockTest {

    private static Map<String, Object> CACHE = new HashMap<>();

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {

        put("key", 1);

        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName() + " read cache " + get("key"));

                }
            }, "Thread-" + i).start();

        }

        for (int j = 0; j < 10; j++) {

            String key = "key" + j;
            int value = j;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    put(key, value);
                    System.out.println(Thread.currentThread().getName() + " put cache ");

                }
            }, "Thread-" + j).start();

        }
    }

    private static Object get(String key) {
        readLock.lock();
        try {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return CACHE.get(key);
        } finally {
            readLock.unlock();
        }
    }

    private static void put(String key, Object value) {
        writeLock.lock();
        try {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CACHE.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
}

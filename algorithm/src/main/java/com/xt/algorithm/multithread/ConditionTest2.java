package com.xt.algorithm.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest2 {

    private static Object[] items;

    private static int addIndex, removeIndex, count;

    private static Lock lock = new ReentrantLock();

    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    public ConditionTest2(int size) {
        items = new Object[size];
    }

    public static void main(String[] args) {
        ConditionTest2 conditionTest2 = new ConditionTest2(10);

        for (int i = 0; i < 20; i++) {
            Integer index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        add(index);
                        Thread.sleep(1000);
                        remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-" + i).start();
        }
    }

    /**
     * 添加元素，如果数组满了，则添加线程进入等待状态，直到有“空位”
     *
     * @param t
     */
    private static void add(Object t) throws InterruptedException {
        lock.lock();

        try {
            while (count == items.length) {
                System.out.println("add method" + Thread.currentThread().getName() + " await...");
                notFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
            System.out.println("add method" + Thread.currentThread().getName() + " success...");
        } finally {
            lock.unlock();
        }
    }

    private static void remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("remove method" + Thread.currentThread().getName() + " await...");
                notEmpty.await();
            }
            removeIndex++;
            if (removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            System.out.println("remove method" + Thread.currentThread().getName() + " success...");
        } finally {
            lock.unlock();
        }
    }
}

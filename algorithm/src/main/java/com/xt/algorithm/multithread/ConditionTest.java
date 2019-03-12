package com.xt.algorithm.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition test
 *
 * condition依赖于Lock对象，condition是从lock对象中new出来的
 */
public class ConditionTest {

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition CONDITION = LOCK.newCondition();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                conditionSignal();
            }
        }, "Thread-2").start();

    }

    private static void conditionWait() throws InterruptedException {
        LOCK.lock();
        try {
            System.out.println("======" + Thread.currentThread().getName() + "在condition中睡眠...");
            CONDITION.await();
            System.out.println("======" + Thread.currentThread().getName() + "从condition中唤醒...");
        } finally {
            LOCK.unlock();
        }
    }

    private static void conditionSignal() {
        LOCK.lock();
        try {
            System.out.println("======" + Thread.currentThread().getName() + "唤醒condition中其他线程...");
            CONDITION.signal();
        } finally {
            LOCK.unlock();
        }
    }
}

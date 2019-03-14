/**
 * $Id: ConnectionPoolTest.java,v 1.0 2019/3/1 9:58 AM
 *
 * @Copyright (c) 2019/3/1, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * wait & notify 实现连接池
 *
 * @author
 * @version $Id: ConnectionPoolTest.java,v 1.0 2019/3/1 9:58 AM
 * @date 2019/3/1 下午9:58 AM
 */
public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);
    //保证所有ConnectionRunner可以同时开始
    static CountDownLatch start = new CountDownLatch(1);
    //main线程将会等待所有ConnectionRunner结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        //线程数量，可以修改线程数量进行观察
        int threadCount = 100;
        end = new CountDownLatch(threadCount);

        int count = 20;

        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread" + String.valueOf(i));
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke :" + threadCount * count);
        System.out.println("got connection  :" + got);
        System.out.println("notGot connection  :" + notGot);
    }

    static class ConnectionRunner implements Runnable {

        private int count;

        private AtomicInteger got;

        private AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                try {
                    //从连接池中获取连接，如果1000毫秒内获取不到，将会返回null、
                    //分别统计连接成功获取到的数量和未获取到的数量
                    Connection connection = pool.fetchConnection(1000);

                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            got.getAndIncrement();
                            pool.releaseConnection(connection);
                        }

                    } else {
                        notGot.getAndIncrement();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

    static class ConnectionPool {
        private LinkedList<Connection> pool = new LinkedList<>();

        public ConnectionPool(int initialize) {
            if (initialize > 0) {
                for (int i = 0; i < initialize; i++) {
                    pool.add(ConnectionDriver.createConnection());
                }
            }
        }

        /**
         * 释放连接
         *
         * @param connection 连接
         */
        public void releaseConnection(Connection connection) {

            synchronized (pool) {

                pool.addLast(connection);
                //连接释放，归还连接池后，通知其他线程，这样其他消费者可以感知到
                pool.notifyAll();
            }
        }

        /**
         * 在millis 毫秒内获取不到Connection 将会返回null
         *
         * @param millis 等待毫秒数
         * @return Connection
         */
        public Connection fetchConnection(long millis) throws InterruptedException {
            synchronized (pool) {
                if (millis <= 0) {
                    //完全超时
                    while (pool.isEmpty()) {
                        //等待唤醒
                        pool.wait();
                    }
                    return pool.removeFirst();
                } else {
                    //等待超时时间
                    long future = System.currentTimeMillis() + millis;

                    long remaining = millis;

                    while (pool.isEmpty() && remaining > 0) {
                        pool.wait(remaining);
                        remaining = future - System.currentTimeMillis();
                    }

                    Connection result = null;

                    if (!pool.isEmpty()) {
                        result = pool.removeFirst();
                    }

                    return result;
                }
            }


        }
    }

    static class ConnectionDriver {

        static class ConnectionHandler implements InvocationHandler {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (method.getName().equals("commit")) {
                    //如果是commit 方法 休眠100毫秒
                    TimeUnit.MILLISECONDS.sleep(100);
                }
                return null;
            }
        }

        //创建一个Connection的动态代理，在commit时休眠100毫秒
        public static final Connection createConnection() {
            return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
        }
    }
}

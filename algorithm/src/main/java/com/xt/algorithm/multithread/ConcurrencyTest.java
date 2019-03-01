/**
 * $Id: ConcurrencyTest.java,v 1.0 2019/2/19 4:25 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/19, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

/**
 * 测试多线程是否一定比单线程快
 *
 * @author wangxiaoteng
 * @version $Id: ConcurrencyTest.java,v 1.0 2019/2/19 4:25 PM wangxiaoteng
 * @date 2019/2/19 下午4:25 PM
 */
public class ConcurrencyTest {

    private static final int count = 100;

    public static void main(String[] args) throws InterruptedException {

        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for (int i = 0; i < count; i++) {
                    a += 5;
                }

            }
        });

        thread.start();
        int b=0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();

        long constTime=System.currentTimeMillis()-start;
        System.out.println("并行花费时间:"+constTime+"毫秒");
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        int a=0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b=0;
        for (int i = 0; i < count; i++) {
            b--;
        }

        long constTime=System.currentTimeMillis()-start;
        System.out.println("串行花费时间:"+constTime+"毫秒");
    }
}

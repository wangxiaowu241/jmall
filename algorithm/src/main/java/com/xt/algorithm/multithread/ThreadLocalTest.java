/**
 * $Id: ThreadLocalTest.java,v 1.0 2019/2/28 3:17 PM
 *
 * @Copyright (c) 2019/2/28, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal 的简单使用
 *
 * @author wangxiaoteng
 * @version $Id: ThreadLocalTest.java,v 1.0 2019/2/28 3:17 PM
 * @date 2019/2/28 下午3:17 PM
 */
public class ThreadLocalTest {

    private static ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("COST:" + ThreadLocalTest.end() + " millis");
    }

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
}

/**
 * $Id: SynchronizedTest.java,v 1.0 2019/2/27 6:00 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/27, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

/**
 * synchronized 测试
 *
 * @author wangxiaoteng
 * @version $Id: SynchronizedTest.java,v 1.0 2019/2/27 6:00 PM wangxiaoteng
 * @date 2019/2/27 下午6:00 PM
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        synchronized (Object.class) {

        }
        m();
    }

    public static synchronized void m() {

    }

}

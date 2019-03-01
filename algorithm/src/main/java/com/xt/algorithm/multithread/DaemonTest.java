/**
 * $Id: DaemonTest.java,v 1.0 2019/2/26 5:02 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/26, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程test
 *
 * @author wangxiaoteng
 * @version $Id: DaemonTest.java,v 1.0 2019/2/26 5:02 PM wangxiaoteng
 * @date 2019/2/26 下午5:02 PM
 */
public class DaemonTest {

    public static void main(String[] args) {

        //main线程在启动了守护线程DaemonRunner线程后，随着main方法的执行完毕而终止，而此时，java虚拟机已经没有非Daemon线程，虚拟机需要退出。
        //Java虚拟机的所有Daemon线程需要立即终止，DaemonRunner需要立即停止，但是DaemonRunner的finally方法并没有执行。

        Thread daemonRunner = new Thread(new DaemonRunner(), "DaemonRunner");
        daemonRunner.setDaemon(true);
        daemonRunner.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("Daemon thread finally run ...");
            }
        }
    }
}

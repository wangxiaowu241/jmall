/**
 * $Id: MultiThreadTest.java,v 1.0 2019/2/26 2:32 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/26, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.multithread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 测试main方法运行时启动的线程
 *
 * @author wangxiaoteng
 * @version $Id: MultiThreadTest.java,v 1.0 2019/2/26 2:32 PM wangxiaoteng
 * @date 2019/2/26 下午2:32 PM
 */
public class MultiThreadTest {
    public static void main(String[] args) {
        //获取java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronize信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历打印线程信息，仅打印线程id和线程名称
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }

        //[5] Monitor Ctrl -Break
        //[4] Signal Dispatcher 分发处理发送给JVM信号的线程
        //[3] Finalizer  调用对象finalize方法的线程
        //[2] Reference Handler 清除reference信息线程
        //[1] main  main线程，用户程序入口
    }
}

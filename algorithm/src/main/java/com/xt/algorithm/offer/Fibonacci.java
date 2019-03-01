/**
 * $Id: Fibonacci.java,v 1.0 2019/1/30 1:37 PM wangxiaoteng
 *
 * @Copyright (c) 2019/1/30, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.offer;

import org.springframework.util.Assert;

/**
 * 斐波那契数列
 *
 * @author wangxiaoteng
 * @version $Id: Fibonacci.java,v 1.0 2019/1/30 1:37 PM wangxiaoteng
 * @date 2019/1/30 下午1:37 PM
 */
public class Fibonacci {

    /**
     * 斐波那契数列java代码展示
     *
     * @param args 参数
     */
    public static void main(String[] args) {

        long recursionStartTime = System.currentTimeMillis();
        Integer fibonacciByRecursion = getFibonacciByRecursion(40);
        System.out.println("斐波那契列递归实现：" + fibonacciByRecursion + "，耗时为" + (System.currentTimeMillis() - recursionStartTime) + "毫秒");

        long arrayStartTime = System.currentTimeMillis();
        Integer fibonacciByArray = getFibonacciByArray(40);
        System.out.println("斐波那契列数组实现：" + fibonacciByArray + "，耗时为" + (System.currentTimeMillis() - arrayStartTime) + "毫秒");

        long frogStairsStartTime = System.currentTimeMillis();
        Integer frogStairsAmount = getFrogStairsAmount(40);
        System.out.println("跳台阶实现：" + frogStairsAmount + "，耗时为" + (System.currentTimeMillis() - frogStairsStartTime) + "毫秒");

        long abNormalFrogStairsStartTime = System.currentTimeMillis();
        Integer abNormalFrogStairsAmount = getAbNormalFrogStairsAmount(20);
        System.out.println("变态跳台阶实现：" + abNormalFrogStairsAmount + "，耗时为" + (System.currentTimeMillis() - abNormalFrogStairsStartTime) + "毫秒");

    }

    /**
     * 斐波那契列的递归实现方式
     * <p>
     * 斐波那契数列由0和1开始，之后的费波那契系数就是由之前的两数相加而得出。
     * 首几个费波那契系数是：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
     * <p>
     * 第n位的值
     *
     * @param n 第n个数据
     * @return 第n个数据的值
     */
    public static Integer getFibonacciByRecursion(int n) {

        Assert.isTrue(n >= 0, "n必须大于等于0");

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return getFibonacciByRecursion(n - 1) + getFibonacciByRecursion(n - 2);
    }

    /**
     * 斐波那契列的数组实现方式
     * <p>
     * 斐波那契数列由0和1开始，之后的费波那契系数就是由之前的两数相加而得出。
     * 首几个费波那契系数是：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
     * <p>
     * 第n位的值
     *
     * @param n 第n个数据
     * @return 第n个数据的值
     */
    public static Integer getFibonacciByArray(int n) {

        Assert.isTrue(n >= 0, "n必须大于等于0");

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }


    /**
     * 二、跳台阶问题
     * <p>
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * <p>
     * 一个台阶只有一种跳法
     * <p>
     * 二个台阶有两种跳法
     * <p>
     * N个台阶，第一次跳只有两种跳法。
     * <p>
     * 假如第一次跳的是1阶，剩下的跳法就是f(n-1)
     * <p>
     * 假如第一次跳的是2阶，剩下的跳法就是f(n-2)
     * <p>
     * 所以f(n)=f(n-1)+f(n-2)
     *
     * @param n n个台阶
     * @return 跳n个台阶一共有多少跳法
     */
    public static Integer getFrogStairsAmount(int n) {

        Assert.isTrue(n >= 1, "台阶数n必须大于1！");

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }


    /**
     * 三、变态跳台阶问题
     * <p>
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * <p>
     * 一个台阶，有1个跳法
     * 两个台阶，有两个跳法
     * 三个台阶，f(3)=f(2)+f(1)+1 ,最后一个1是一次跳3个台阶
     * N个台阶，f(n)=f(n-1)+f(n-2)+...+f(1)+1
     * 而f(n-1)=f(n-2)+f(n-3)+...+f(1)+1
     * 所以，f(n)=2f(n-1)=2的N-2次方乘以(f(1)+1)，而f(1)+1=2
     * 所以f(n)=2的N-1次方
     * <p>
     *
     * @param n n个台阶
     * @return n个台阶一共有多少跳法
     */
    public static Integer getAbNormalFrogStairsAmount(int n) {
        //左移运算
        return 1 << --n;
    }
}

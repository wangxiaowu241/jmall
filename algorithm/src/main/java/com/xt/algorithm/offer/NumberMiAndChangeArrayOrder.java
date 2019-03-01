/**
 * $Id: NumberMiAndChangeArrayOrder.java,v 1.0 2019/2/9 7:49 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/9, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.offer;

import java.util.Arrays;

/**
 * 数值的整数次方和调整数组元素顺序
 *
 * @author wangxiaoteng
 * @version $Id: NumberMiAndChangeArrayOrder.java,v 1.0 2019/2/9 7:49 PM wangxiaoteng
 * @date 2019/2/9 下午7:49 PM
 */
public class NumberMiAndChangeArrayOrder {

    public static void main(String[] args) {
        System.out.println(getNumberPower(2, -5));
        System.out.println(getNumberPowerByShift(2, -5));

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(Arrays.toString(changeArrayOrder(array)));
    }


    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * <p>
     * 累乘法，时间复杂度 O(n)
     *
     * @param number 浮点数base
     * @param power  幂次方
     * @return 浮点数的N次方
     */
    public static double getNumberPower(double number, int power) {

        int absPower = Math.abs(power);

        double result = 1;

        for (int i = 1; i <= absPower; i++) {
            result = result * number;
        }

        if (power > 0) {
            return result;

        } else {
            return 1 / result;
        }

    }

    /**
     * 比较浮点数是否等于或近似于0
     *
     * @param number 浮点数
     * @return 浮点数是否等于或近似于0
     */
    private static boolean equalZero(double number) {
        if (-0.00001 < number && number < 0.00001) {
            return true;
        }
        return false;
    }


    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * <p>
     * 右移法，时间复杂度 log(n)
     *
     * @param number 浮点数base
     * @param power  幂次方
     * @return 浮点数的N次方
     */
    public static double getNumberPowerByShift(double number, int power) {

        //如果底数等于0并且指数小于0
        if (equalZero(number) && power < 0) {
            return 0.0;
        }

        int absPower = Math.abs(power);

        double result = getPower(number, absPower);

        if (power > 0) {
            return result;
        } else {
            return 1 / result;
        }

    }

    /**
     * 求number的power次幂
     * <p>
     * X^y=X^y/2 * X^y/2
     *
     * @param number 数值
     * @param power  幂值
     * @return number的power次幂
     */
    private static double getPower(double number, int power) {

        if (power == 0) {
            return 1;
        }

        if (power == 1) {
            return number;
        }

        //X^y=X^y/2 * X^y/2

        double result = getPower(number, power >> 1);

        result *= result;

        //如果指数n为奇数，则要再乘一次底数number，原因除2的时候抹去了
        if ((power & 1) == 1) {
            result *= number;
        }

        return result;
    }


    /**
     * 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * <p>
     * 时间复杂度 O(n)
     *
     * @param array 数组
     * @return 改变顺序后的数组
     */
    public static int[] changeArrayOrder(int[] array) {


        int[] eventNumberArray = new int[array.length];
        int eventNumberArrayIndex = 0;
        int notEventNumberArrayIndex = 0;

        int[] notEventNumberArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (isEventNumber(array[i])) {
                eventNumberArray[eventNumberArrayIndex] = array[i];
                eventNumberArrayIndex++;
            } else {
                notEventNumberArray[notEventNumberArrayIndex] = array[i];
                notEventNumberArrayIndex++;
            }
        }

        for (int i = 0; i < eventNumberArrayIndex; i++) {
            notEventNumberArray[notEventNumberArrayIndex + i] = eventNumberArray[i];
        }

        return notEventNumberArray;
    }

    private static boolean isEventNumber(int number) {
        return (number & 1) == 1;
    }
}

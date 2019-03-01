/**
 * $Id: ArraySearchAndReplaceBlank.java,v 1.0 2019/1/30 4:58 PM wangxiaoteng
 *
 * @Copyright (c) 2019/1/30, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.offer;

/**
 * 二维数组查找以及空格替换
 *
 * @author wangxiaoteng
 * @version $Id: ArraySearchAndReplaceBlank.java,v 1.0 2019/1/30 4:58 PM wangxiaoteng
 * @date 2019/1/30 下午4:58 PM
 */
public class ArraySearchAndReplaceBlank {

    public static void main(String[] args) {

        int[][] arr = new int[2][3];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{2, 3, 4};

        System.out.println(findInArray(arr, 4));

        String originStr = "We Are Happy";

        System.out.println(replaceBlank(originStr, "%20"));
        System.out.println(replaceBlank2(originStr, "%20"));
    }

    /**
     * 一、二维数组查找
     * <p>
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
     * <p>
     * 每一列都按照从上到下递增的顺序排序。
     * <p>
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     */
    public static boolean findInArray(int[][] array, int target) {

        //1.矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
        //2.因此从左下角开始查找，当要查找数字比左下角数字大时。右移 要查找数字比左下角数字小时，上移。这样找的速度最快。

        //从左下角开始查找
        //行
        int row = array.length - 1;

        //列
        int column = 0;

        while (row >= 0 && column < array[0].length) {

            if (array[row][column] > target) {
                row--;

            } else if (array[row][column] < target) {

                column++;
            } else {
                return true;
            }
        }

        return false;
    }


    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param originString 原始字符串
     * @param replaceStr   替换为的字符串
     * @return 替换后的字符串
     */
    public static String replaceBlank(String originString, String replaceStr) {

        StringBuilder builder = new StringBuilder();

        for (char c : originString.toCharArray()) {
            if (" ".equals(String.valueOf(c))) {
                builder.append(replaceStr);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param originString 原始字符串
     * @param replaceStr   替换为的字符串
     * @return 替换后的字符串
     */
    public static String replaceBlank2(String originString, String replaceStr) {
        return originString.replaceAll("\\s", replaceStr);
    }
}

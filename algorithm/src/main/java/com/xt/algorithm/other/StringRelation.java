/**
 * $Id: StringRelation.java,v 1.0 2019/2/18 10:09 AM wangxiaoteng
 *
 * @Copyright (c) 2019/2/18, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 字符串相关的几道算法题
 *
 * @author wangxiaoteng
 * @version $Id: StringRelation.java,v 1.0 2019/2/18 10:09 AM wangxiaoteng
 * @date 2019/2/18 下午10:09 AM
 */
public class StringRelation {

    public static void main(String[] args) {
        String[] strs = {"customer", "car", "cat"};
        System.out.println(getMaxCommonPrefix(strs));
        System.out.println(getLongestPalindrome("abccccdd"));
        System.out.println(checkPalindrome("abcdcba"));

        System.out.println(getBracketDepth("((()))"));

        System.out.println(castStringToInteger("12345"));
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 思路很简单！先利用Arrays.sort(strs)为数组排序，再将数组第一个元素和最后一个元素的字符从前往后对比即可！
     * 原因：排完序后，差异最大的应该是第一个元素与最后一个元素，第一个元素与最后一个元素的最长公共前缀就是整个数组的最长公共前缀
     *
     * @param strArray 字符串数组
     * @return 最长公共前缀
     */
    private static String getMaxCommonPrefix(String[] strArray) {

        if (null == strArray || strArray.length == 0) {
            return "";
        }
        //数组长度
        int length = strArray.length;

        //数组排序，正序排序
        Arrays.sort(strArray);
        //第一个元素
        String firstElement = strArray[0];
        //最后一个元素
        String lastElment = strArray[length - 1];
        //存放公共前缀
        StringBuilder str = new StringBuilder();

        //由于数组是正序排序，所以第一个元素的数量应该是最少的

        char[] firstCharArray = firstElement.toCharArray();

        char[] lastCharArray = lastElment.toCharArray();

        for (int i = 0; i < firstCharArray.length; i++) {
            if (firstCharArray[i] == lastCharArray[i]) {
                str.append(firstCharArray[i]);
            } else {
                break;
            }
        }

        return str.toString();
    }

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
     * <p>
     * 回文串：“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
     * <p>
     * 思路：
     * 我们上面已经知道了什么是回文串？现在我们考虑一下可以构成回文串的两种情况：
     * <p>
     * 字符出现次数为双数的组合
     * 字符出现次数为双数的组合+一个只出现一次的字符
     * 统计字符出现的次数即可，双数才能构成回文。因为允许中间一个数单独出现，比如“abcba”，所以如果最后有字母落单，总长度可以加 1。
     * 首先将字符串转变为字符数组。然后遍历该数组，判断对应字符是否在hashset中，如果不在就加进去，如果在就让count++，然后移除该字符！这样就能找到出现次数为双数的字符个数。
     *
     * @param str 字符串
     * @return 最大回文串的长度
     */
    private static int getLongestPalindrome(String str) {

        if (null == str || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        //存放单数的字符
        Set<String> singleCharSet = new HashSet<>();

        int doubleCharSetLength = 0;

        for (char c : chars) {
            if (singleCharSet.contains(String.valueOf(c))) {
                singleCharSet.remove(String.valueOf(c));
                doubleCharSetLength++;
            } else {
                singleCharSet.add(String.valueOf(c));
            }
        }

        if (singleCharSet.size() > 0) {
            return doubleCharSetLength * 2 + 1;
        } else {
            return doubleCharSetLength * 2;
        }
    }

    /**
     * 验证回文串
     * <p>
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * @return 是否是回文串
     */
    private static boolean checkPalindrome(String str) {

        //null 返回 false
        if (null == str) {
            return false;
        }
        //将字符串转成char数组
        char[] charArray = str.toCharArray();

        //定义字符串首尾指针
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(charArray[start])) {
                start++;
            } else if (!Character.isLetterOrDigit(charArray[end])) {
                end--;
            } else {
                //是字母和数字字符
                if (Character.toLowerCase(charArray[start]) != Character.toLowerCase(charArray[end])) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    /**
     * 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     *
     * @param str 给定的字符串
     * @return 最长的回文子串
     */
//    private static String getLongestPalindrome(String str) {
//
//    }


    /**
     * 一个合法的括号匹配序列有以下定义:
     * <p>
     * 空串""是一个合法的括号匹配序列
     * 如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
     * 如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
     * 每个合法的括号序列都可以由以上规则生成。
     * 例如: "","()","()()","((()))"都是合法的括号序列 对于一个合法的括号序列我们又有以下定义它的深度:
     * <p>
     * 空串""的深度是0
     * 如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y)
     * 如果"X"的深度是x,那么字符串"(X)"的深度是x+1
     * 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
     * <p>
     * 输入描述:
     * 输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。
     * <p>
     * 输出描述:
     * 输出一个正整数,即这个序列的深度。
     * <p>
     * 输入:
     * (())
     * 输出:
     * 2
     *
     * @param str 字符串
     * @return 括号匹配深度
     */
    public static int getBracketDepth(String str) {

        if (null == str || str.length() == 0) {
            return 0;
        }
        int max = 0;
        int count = 0;

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                count++;
            } else if (charArray[i] == ')') {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }


    /**
     * 把字符串转换成整数
     * <p>
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要
     * 求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     *
     * @param str 字符串
     * @return 整数
     */
    private static int castStringToInteger(String str) {

        if (null == str || str.length() == 0) {
            return 0;
        }
        //是否有符号的标识
        int flag = 0;

        int i = 0;

        char[] charArray = str.toCharArray();

        //判断第一个字符有没有符号
        if (charArray[0] == '+') {
            flag = 1;
            i = 1;
        } else if (charArray[0] == '-') {
            flag = -1;
            i = 1;
        }

        int result = 0;
        for (; i < charArray.length; i++) {

            if (Character.isDigit(charArray[i])) {
                //是数字
                int temp = charArray[i] - '0';
                result = temp + result * 10;
            } else {
                //不是数字
                return 0;
            }
        }
        return flag >= 0 ? result : -result;
    }
}

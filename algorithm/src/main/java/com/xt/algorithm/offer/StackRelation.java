/**
 * $Id: StackRelation.java,v 1.0 2019/2/13 11:24 AM wangxiaoteng
 *
 * @Copyright (c) 2019/2/13, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.offer;

import java.util.Stack;

/**
 * 栈相关的算法题
 *
 * @author wangxiaoteng
 * @version $Id: StackRelation.java,v 1.0 2019/2/13 11:24 AM wangxiaoteng
 * @date 2019/2/13 下午11:24 AM
 */
public class StackRelation {

    public static void main(String[] args) {

        //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        myQueue.push(4);
        System.out.println(myQueue.pop());

        //
        int[] pushOrder = new int[]{1, 2, 3, 4, 5};
        int[] popOrder = new int[]{4, 5, 3, 2, 1};
        int[] popOrder2 = new int[]{4, 3, 5, 1, 2};

        System.out.println(isStackPopOrder(pushOrder, popOrder));
        System.out.println(isStackPopOrder(pushOrder, popOrder2));
    }

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     *
     * @return true or false
     */
    public static boolean isStackPopOrder(int[] pushOrder, int[] popOrder) {

        /**
         *
         * 链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
         * 来源：牛客网
         *
         * 【思路】借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，
         * 所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
         *
         * 举例：
         *
         * 入栈1,2,3,4,5
         *
         * 出栈4,5,3,2,1
         *
         * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
         *
         * 此时栈顶2≠4，继续入栈3
         *
         * 此时栈顶3≠4，继续入栈4
         *
         * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
         *
         * 此时栈顶3≠5，继续入栈5
         *
         * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
         *
         * ….
         *
         * 依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
         */

        if (pushOrder.length != popOrder.length) {
            return false;
        }

        //辅助栈
        Stack<Integer> stack = new Stack<>();

        //出栈索引
        int popIndex = 0;

        for (int i = 0; i < pushOrder.length; i++) {

            //入栈
            stack.push(pushOrder[i]);
            //如果栈顶的元素与出栈的元素相等，出栈，否则，继续执行
            while (!stack.isEmpty() && stack.peek().equals(popOrder[popIndex])) {
                //出栈
                stack.pop();
                //出栈索引+1
                popIndex++;
            }
        }
        return stack.isEmpty();
    }


}

/**
 * $Id: LinkedListRelation.java,v 1.0 2019/2/10 1:02 PM wangxiaoteng
 *
 * @Copyright (c) 2019/2/10, Lianjia Group All Rights Reserved.
 */
package com.xt.algorithm.offer;

/**
 * 链表相关的算法题
 *
 * @author wangxiaoteng
 * @version $Id: LinkedListRelation.java,v 1.0 2019/2/10 1:02 PM wangxiaoteng
 * @date 2019/2/10 下午1:02 PM
 */
public class LinkedListRelation {

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        fifth.setNext(fourth);
        fourth.setNext(third);
        third.setNext(second);
        second.setNext(first);

        System.out.println(getDescNumberNode(fifth, 1).getValue());

        ListNode reverse = reverseByWhile(fifth);
        System.out.println(reverse.getValue());

        ListNode reverseByRecursion = reverseByRecursion(fifth);
        System.out.println(reverseByRecursion);


        ListNode firstNode = first;
        first.setNext(third);
        third.setNext(fifth);

        ListNode secondNode = second;
        second.setNext(fourth);
        //ListNode mergeNode = mergeNodeByWhile(firstNode, secondNode);
        ListNode mergeNode = mergeNodeByRecursion(firstNode, secondNode);
        System.out.println(mergeNode);
    }

    /**
     * 链表中倒数第n个节点
     *
     * @param node 链表
     * @param n    倒数第n个
     * @return 倒数第n个节点
     */
    public static ListNode getDescNumberNode(ListNode node, int n) {

        //总节点数
        int count = 0;

        ListNode next = node;

        ListNode lastDescNumberNode = node;

        while (next != null) {
            count++;
            if (count > n) {
                //当next节点跑了n-1个节点后，lastDescNumberNode才开始跑，当next节点为最后一个节点时，lastDescNumberNode位倒数第n个节点
                lastDescNumberNode = lastDescNumberNode.getNext();
            }
            next = next.getNext();
        }

        if (count < n) {
            //总节点数count小于n
            return null;
        }

        return lastDescNumberNode;
    }


    /**
     * 反转链表（非环形链表）-while循环实现
     * <p>
     * 注意：修改链表值后，再指向下一个的时候，java中的引用问题
     * <p>
     *
     * @param node 链表
     */
    public static ListNode reverseByWhile(ListNode node) {

        //反转后链表的前节点
        ListNode pre = null;
        //反转后链表的后节点
        ListNode next = null;

        while (node != null) {

            //这里用了clone，避免java引用问题
            ListNode nodeClone = node.clone();
            //反转后链表的后节点应该是原链表的前节点
            next = nodeClone;
            next.setNext(pre);
            //反转后链表的前节点应该是原链表的后节点
            pre = nodeClone;

            node = node.getNext();
        }

        return next;
    }


    /**
     * 反转链表（非环形链表）-递归实现
     *
     * @param node 链表
     * @return 反转后的链表
     */
    public static ListNode reverseByRecursion(ListNode node) {

        if (node == null || node.getNext() == null) {
            return node;
        }

        ListNode reverseNode = reverseByRecursion(node.getNext());

        ListNode nextNode = node.getNext();

        nextNode.setNext(node);
        node.setNext(null);

        return reverseNode;
    }

    /**
     * 合并节点 -while循环版本
     * 时间复杂度 O(n)
     * <p>
     * 规则：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param firstNode  第一个节点
     * @param secondNode 第二个节点
     * @return 合并后的节点
     */
    public static ListNode mergeNodeByWhile(ListNode firstNode, ListNode secondNode) {

        ListNode mergeNode;

        //思路：两个链表的每个节点相互比较，小的放在新的链表的节点上，然后小的节点所在的链表指针指向下一个节点

        if (firstNode == null) {
            return secondNode;
        } else if (secondNode == null) {
            return firstNode;
        } else {

            //先处理头部节点
            if (firstNode.getValue() <= secondNode.getValue()) {
                mergeNode = firstNode.clone();
                firstNode = firstNode.getNext();
            } else {
                mergeNode = secondNode.clone();
                secondNode = secondNode.getNext();
            }

            //循环比较两个节点的大小
            //新链表的指针
            ListNode newNode = mergeNode;
            while (firstNode != null && secondNode != null) {

                if (firstNode.getValue() <= secondNode.getValue()) {
                    newNode.setNext(firstNode.clone());
                    newNode = newNode.getNext();
                    firstNode = firstNode.getNext();
                } else {
                    newNode.setNext(secondNode.clone());
                    newNode = newNode.getNext();
                    secondNode = secondNode.getNext();
                }
            }

            //如果第一个链表没走到最后一个节点，说明第二个链表走到最后了，将第一个链表直接接在新的链表上
            if (firstNode != null) {
                newNode.setNext(firstNode);
            }

            //如果第二个链表没走到最后一个节点，说明第一个链表走到最后了，将第二个链表直接接在新的链表上
            if (secondNode != null) {
                newNode.setNext(secondNode);
            }
            return mergeNode;
        }
    }

    /**
     * 合并节点 -递归版本
     * 时间复杂度 O(n)
     * <p>
     * 规则：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param firstNode  第一个节点
     * @param secondNode 第二个节点
     * @return 合并后的节点
     */
    public static ListNode mergeNodeByRecursion(ListNode firstNode, ListNode secondNode) {

        ListNode headerNode = null;
        if (firstNode == null) {
            return secondNode;
        } else if (secondNode == null) {
            return firstNode;
        } else {
            //先处理头部节点
            if (firstNode.getValue() <= secondNode.getValue()) {
                headerNode = firstNode.clone();
                firstNode = firstNode.getNext();
            } else {
                headerNode = secondNode.clone();
                secondNode = secondNode.getNext();
            }
            headerNode.setNext(getSmallNode(firstNode, secondNode));
        }
        return headerNode;
    }

    private static ListNode getSmallNode(ListNode firstNode, ListNode secondNode) {

        if (firstNode == null) {
            return secondNode;
        } else if (secondNode == null) {
            return firstNode;
        } else {
            ListNode smallNode = null;
            if (firstNode.getValue() <= secondNode.getValue()) {
                smallNode = firstNode.clone();
                firstNode = firstNode.getNext();
            } else {
                smallNode = secondNode.clone();
                secondNode = secondNode.getNext();
            }
            smallNode.setNext(getSmallNode(firstNode, secondNode));
            return smallNode;
        }
    }
}

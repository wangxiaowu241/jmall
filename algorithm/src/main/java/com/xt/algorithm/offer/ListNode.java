package com.xt.algorithm.offer;

public class ListNode {

    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public ListNode clone() {
        ListNode listNode = new ListNode(value);
        listNode.setNext(next);
        return listNode;
    }
}
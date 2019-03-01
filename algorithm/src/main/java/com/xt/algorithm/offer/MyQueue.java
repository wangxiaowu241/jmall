package com.xt.algorithm.offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class MyQueue {

    //栈：后进先出 LIFO
    //队列：先进先出  FIFO

    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void push(int e) {

        firstStack.push(e);

    }

    public int pop() {

        if (firstStack.empty() && secondStack.empty()) {
            throw new RuntimeException("no elements!");
        }

        while (secondStack.isEmpty()) {
            while (!firstStack.empty()) {
                Integer element = firstStack.pop();
                secondStack.push(element);
            }
        }
        return secondStack.pop();
    }
}
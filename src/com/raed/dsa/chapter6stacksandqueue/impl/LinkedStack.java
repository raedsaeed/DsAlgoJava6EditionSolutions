package com.raed.dsa.chapter6stacksandqueue.impl;

import com.raed.dsa.chapter2oodesign.impl.DoublyLinkedList;
import com.raed.dsa.chapter2oodesign.impl.LinkedList;
import com.raed.dsa.chapter2oodesign.impl.SingleLinkedList;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public class LinkedStack<T> implements Stack<T> {
    private final LinkedList<T> data;

    public LinkedStack() {
        data = new SingleLinkedList<>();
    }

    public LinkedStack(Stack<T> stack) {
        this();
        copy(stack);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(T t) {
        data.addFirst(t);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return data.removeFirst();
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return data.getFirst();
    }

    @Override
    public void clear() {
        data.clear();
    }

    private void recursiveClear() {
        if (top() != null) {
            pop();
            recursiveClear();
        }
    }

    public void printElements() {
        data.printElements();
    }

    public void copy(Stack<T> stack) {
        Deque<T> queue = new DoublyLinkedList<>();
        while (stack.top() != null) {
            queue.addFirst(stack.pop());
        }

        while (queue.first() != null) {
            push(queue.removeFirst());
        }
    }

    public void transfer(Stack<T> s, Stack<T> t) {
        Stack<T> temp = new LinkedStack<>();
        temp.copy(s);
        s.copy(t);
        t.copy(temp);
    }
}

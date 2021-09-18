package com.raed.dsa.chapter6.impl;

import com.raed.dsa.chapter2.impl.LinkedList;
import com.raed.dsa.chapter2.impl.SingleLinkedList;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public class LinkedStack<T> implements Stack<T> {
    private final LinkedList<T> data;

    public LinkedStack() {
        data = new SingleLinkedList<>();
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
}

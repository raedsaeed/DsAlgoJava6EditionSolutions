package com.raed.dsa.chapter6stacksandqueue.impl;

import com.raed.dsa.chapter7list.ArrayList;
import com.raed.dsa.chapter7list.List;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public class ArrayQueue<E> implements Queue<E>, Cloneable {
    private static final int INITIAL_CAPACITY = 16;
    private final List<E> data;

    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = new ArrayList<>(capacity);
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
    public void enqueue(E e) {
        data.add(e);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        return data.remove(0);
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    @Override
    public void clear() {
        while (size() != 0) {
            dequeue();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ArrayQueue<E> clone() throws CloneNotSupportedException {
        ArrayQueue<E> clone = null;
        try {
            clone = (ArrayQueue<E>) super.clone();
        } catch (CloneNotSupportedException ignore) {

        }
        return clone;
    }
}

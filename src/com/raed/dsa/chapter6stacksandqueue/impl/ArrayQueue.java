package com.raed.dsa.chapter6stacksandqueue.impl;

/**
 * Created by Raed Saeed on 17/09/2021
 **/

@SuppressWarnings("UNCHECKED")
public class ArrayQueue<E> implements Queue<E>, Cloneable {
    private static final int INITIAL_CAPACITY = 16;
    private final E[] data;
    private int size;
    private int f;

    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) throw new IllegalStateException("Queue is Full");
        int available = (f + size) % data.length;
        data[available] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return answer;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[f];
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

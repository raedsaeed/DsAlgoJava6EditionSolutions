package com.raed.dsa.chapter6.impl;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public class ArrayQueue<E> implements Queue<E> {
    private static final int INITIAL_CAPACITY = 1000;
    private int size;
    private int first;
    private final E[] data;

    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
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
        if (data.length == size) throw new IllegalArgumentException("Queue is full");
        int available = (first + size) % data.length;
        data[available] = e;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E temp = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return temp;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[first];
    }

    @Override
    public void clear() {
        while (size != 0) {
            dequeue();
        }
    }
}

package com.raed.dsa.chapter6.impl;

/**
 * Created by Raed Saeed on 17/09/2021
 **/

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T> {
    private static final int INITIAL_CAPACITY = 1000;
    private final T[] data;
    private int size = -1;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size + 1;
    }

    @Override
    public boolean isEmpty() {
        return size == -1;
    }

    @Override
    public void push(T t) {
        if (size < data.length) {
            data[++size] = t;
        } else {
            throw new IllegalArgumentException("Stack is full");
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = data[size];
        data[size] = null;
        size--;
        return item;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return data[size];
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            while (size != -1) {
                data[size] = null;
                size--;
            }
        }
    }

    private void recursiveClear() {
        if (top() != null) {
            pop();
            recursiveClear();
        }
    }
}

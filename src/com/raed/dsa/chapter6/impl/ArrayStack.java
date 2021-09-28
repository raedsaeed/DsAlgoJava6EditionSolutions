package com.raed.dsa.chapter6.impl;

import com.raed.dsa.chapter7.ArrayList;
import com.raed.dsa.chapter7.List;

/**
 * Created by Raed Saeed on 17/09/2021
 **/

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T>, Cloneable {
    private static final int INITIAL_CAPACITY = 1000;
    private final List<T> data;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public ArrayStack(Stack<T> stack) {
        this(stack.size());
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
        data.add(t);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public void copy(Stack<T> source) {
        int i = data.size();
        while (i > 0) {
            data.add(source.pop());
            i--;
        }
    }

    private void recursiveClear() {
        if (top() != null) {
            pop();
            recursiveClear();
        }
    }
}

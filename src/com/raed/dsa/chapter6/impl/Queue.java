package com.raed.dsa.chapter6.impl;

import com.raed.dsa.chapter7.Collections;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public interface Queue<E> extends Collections<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E first();

    void clear();

    default void copy(Stack<E> stack) {
    }

    default void copy(Queue<E> queue) {
    }

    @Override
    default Iterator<E> iterator() {
        return null;
    }

    @Override
    default Object[] toArray() {
        return new Object[0];
    }
}

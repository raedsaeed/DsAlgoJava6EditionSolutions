package com.raed.dsa.chapter6.impl;

import com.raed.dsa.chapter2.impl.CircleLinkedList;
import com.raed.dsa.chapter2.impl.CircularLinkedList;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public class CircleQueue<E> implements CircularQueue<E> {
    private final CircleLinkedList<E> list;

    public CircleQueue() {
        list = new CircularLinkedList<>();
    }

    @Override
    public void rotate() {
        list.rotate();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        return list.removeFirst();
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return list.getFirst();
    }

    @Override
    public void clear() {
        list.clear();
    }
}

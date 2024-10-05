package com.raed.dsa.chapter6stacksandqueue.impl;

/**
 * Created by Raed Saeed on 19/09/2021
 **/
public interface Deque<E> {
    int size();

    boolean isEmpty();

    E first();

    E last();

    void addFirst(E e);

    void addLast(E e);

    E removeFirst();

    E removeLast();
}

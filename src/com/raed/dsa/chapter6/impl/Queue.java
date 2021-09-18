package com.raed.dsa.chapter6.impl;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E first();

    void clear();
}

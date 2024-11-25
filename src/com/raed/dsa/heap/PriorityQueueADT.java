package com.raed.dsa.heap;


import com.raed.dsa.chapter7list.Collections;

/**
 * Created by Raed Saeed on 14/11/2024
 */
public interface PriorityQueueADT<T> extends Collections<T> {
    int size();

    boolean isEmpty();

    void add(T element);

    T front();

    T peek();
}

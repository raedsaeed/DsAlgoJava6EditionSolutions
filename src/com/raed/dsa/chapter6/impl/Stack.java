package com.raed.dsa.chapter6.impl;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public interface Stack<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E pop();

    E top();

    void clear();

    default void copy(Stack<E> source) {
    }
}

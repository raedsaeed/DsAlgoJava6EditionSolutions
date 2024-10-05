package com.raed.dsa.chapter2oodesign.impl;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public interface LinkedList<E> {
    int size();

    boolean isEmpty();

    E getFirst();

    E getLast();

    void addFirst(E e);

    E removeFirst();

    void addLast(E e);

    E removeLast();

    boolean contain(E e);

    void printElements();

    void reverse();

    void clear();
}

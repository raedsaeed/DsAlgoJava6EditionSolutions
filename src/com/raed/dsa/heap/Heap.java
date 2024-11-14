package com.raed.dsa.heap;


import com.raed.dsa.chapter7list.Collections;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 14/11/2024
 */

public interface Heap<T> extends Collections<T> {
    int size();

    boolean isEmpty();

    void add(T t);

    T element(int index);

    void upHeap(int index) throws IllegalArgumentException;

    void downHeap(int index) throws IllegalArgumentException;

    void heapify(T[] array);

    T peek();

    int parent(int index) throws IllegalArgumentException;

    int left(int index) throws IllegalArgumentException;

    int right(int index) throws IllegalArgumentException;

    boolean hasLeft(int index) throws IllegalArgumentException;

    boolean hasRight(int index) throws IllegalArgumentException;

    Iterator<T> iterator();
}

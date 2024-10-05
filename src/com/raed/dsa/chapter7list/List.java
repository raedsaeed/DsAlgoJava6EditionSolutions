package com.raed.dsa.chapter7list;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 26/09/2021
 **/
public interface List<T> extends Collections<T>{
    int size();

    boolean isEmpty();

    @Override
    default Object[] toArray() {
        return new Object[0];
    }

    @Override
    default Iterator<T> iterator() {
        return null;
    }

    T get(int position) throws ArrayIndexOutOfBoundsException;

    boolean add(T element);

    void add(int position, T element) throws ArrayIndexOutOfBoundsException;

    T set(int position, T element) throws ArrayIndexOutOfBoundsException;

    T remove(int position) throws ArrayIndexOutOfBoundsException;

    boolean remove(T element);

    void clear();
}

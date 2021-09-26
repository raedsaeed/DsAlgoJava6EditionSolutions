package com.raed.dsa.chapter7;

/**
 * Created by Raed Saeed on 26/09/2021
 **/
public interface PositionalList<T> extends Collections<T> {
    int size();

    boolean isEmpty();

    // access methods
    Position<T> first();

    Position<T> last();

    Position<T> before(Position<T> p) throws IllegalArgumentException;

    Position<T> after(Position<T> p) throws IllegalArgumentException;

    // update methods

    Position<T> addFirst(T element);

    Position<T> addLast(T element);

    Position<T> addBefore(Position<T> p, T element) throws IllegalArgumentException;

    Position<T> addAfter(Position<T> position, T element) throws IllegalArgumentException;

    T set(Position<T> position, T newElement) throws IllegalArgumentException;

    T remove(Position<T> position) throws IllegalArgumentException;

}

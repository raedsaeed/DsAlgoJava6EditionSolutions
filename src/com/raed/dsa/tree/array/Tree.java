package com.raed.dsa.tree.array;


/**
 * Created by Raed Saeed on 13/11/2024
 */

public interface Tree<E> extends Iterable<E> {
    E getElement(int index);

    boolean isEmpty();

    int size();

    Iterable<Integer> children(int index);

    int getChildrenNumber(int index);

    int parent(int index) throws IndexOutOfBoundsException;

    boolean isInternal(int index) throws IndexOutOfBoundsException;

    boolean isExternal(int index) throws IndexOutOfBoundsException;
}

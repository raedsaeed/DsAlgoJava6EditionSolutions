package com.raed.dsa.tree.array;


/**
 * Created by Raed Saeed on 13/11/2024
 */
public interface BinaryIndexableTree<E> extends IndexableTree<E> {
    int left(int index) throws IllegalArgumentException;

    int right(int index) throws IllegalArgumentException;

    int sibling(int index) throws IllegalArgumentException;
}

package com.raed.dsa.tree.binary.linked;

import com.raed.dsa.chapter7list.Position;

/**
 * Created by Raed Saeed on 13/10/2021
 **/
public interface BinaryTree<E> extends Tree<E> {
    /**
     * Returns the Position of p's left child (or null if no child exists).
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's right child (or null if no child exists).
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}

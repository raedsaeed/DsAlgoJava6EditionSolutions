package com.raed.dsa.chapter8tree;

import com.raed.dsa.chapter7list.Collections;
import com.raed.dsa.chapter7list.Position;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 13/10/2021
 **/
public interface Tree<E> extends Collections<E> {
    /*
     * The tree ADT then supports the following accessor methods, allowing a user
     * to navigate the various positions of a tree T:
     */

    /**
     * Returns the position of the root of the tree
     * (or null if empty).
     */
    Position<E> root();

    /**
     * Returns the position of the parent of position p
     * (or null if p is the root).
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns an iterable collection containing the children of
     * position p (if any).
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the number of children of position p.
     */
    int getChildrenNum(Position<E> p) throws IllegalArgumentException;


    /*
     * If a tree T is ordered, then children(p) reports the children of p in order.
     * In addition to the above fundamental accessor methods, a tree supports the
     * following query methods
     */

    /**
     * Returns true if position p has at least one child.
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if position p does not have any children.
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if position p is the root of the tree.
     */
    boolean isRoot(Position<E> p);

    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}

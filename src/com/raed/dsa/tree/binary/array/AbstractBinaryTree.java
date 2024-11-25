package com.raed.dsa.tree.binary.array;


import com.raed.dsa.chapter7list.ArrayList;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 13/11/2024
 */

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public int left(int index) throws IllegalArgumentException {
        if (index < 0 || index > size()) throw new IllegalArgumentException("Invalid index " + index);
        int leftChild = 2 * index + 1;
        if (leftChild >= size()) return -1;
        return leftChild;
    }

    @Override
    public int right(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Invalid index " + index);
        int rightChild = 2 * index + 2;
        if (rightChild >= size()) return -1;
        return rightChild;
    }

    @Override
    public int sibling(int index) throws IllegalArgumentException {
        int parent = parent(index);
        if (left(parent) == index) return right(index);
        return left(index);
    }

    public boolean hasLeft(int index) {
        return left(index) != -1;
    }

    public boolean hasRight(int index) {
        return right(index) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        ArrayList<E> list = new ArrayList<>();
        return inorder(0, list).iterator();
    }

    public Iterable<E> inorder(int index, ArrayList<E> elements) {
        if (hasLeft(index)) {
            inorder(left(index), elements);
        }
        elements.add(getElement(index));
        if (hasRight(index)) {
            inorder(right(index), elements);
        }
        return elements;
    }
}

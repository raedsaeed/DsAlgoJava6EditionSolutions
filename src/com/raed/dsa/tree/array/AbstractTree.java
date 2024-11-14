package com.raed.dsa.tree.array;


import com.raed.dsa.chapter6stacksandqueue.impl.LinkedQueue;
import com.raed.dsa.chapter6stacksandqueue.impl.Queue;
import com.raed.dsa.chapter7list.ArrayList;

/**
 * Created by Raed Saeed on 13/11/2024
 */
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean isInternal(int index) throws IndexOutOfBoundsException {
        return getChildrenNumber(index) > 0;
    }

    @Override
    public boolean isExternal(int index) throws IndexOutOfBoundsException {
        return getChildrenNumber(index) == 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<E> preorder() {
        ArrayList<E> positions = new ArrayList<>();
        return preorderSubtree(0, positions);
    }

    private Iterable<E> preorderSubtree(int index, ArrayList<E> positions) {
        positions.add(getElement(index));
        for (int child : children(index)) {
            preorderSubtree(child, positions);
        }
        return positions;
    }

    public Iterable<E> postorder() {
        ArrayList<E> positions = new ArrayList<>();
        return postorderSubtree(0, positions);
    }


    private Iterable<E> postorderSubtree(int index, ArrayList<E> positions) {
        for (int child : children(index)) {
            postorderSubtree(child, positions);
        }
        positions.add(getElement(index));
        return positions;
    }

    public Iterable<E> breadthFirst() {
        ArrayList<E> elements = new ArrayList<>();
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(0);
        while (!queue.isEmpty()) {
            int index = queue.dequeue();
            elements.add(getElement(index));
            for (int child : children(index)) {
                queue.enqueue(child);
            }
        }

        return elements;
    }
}

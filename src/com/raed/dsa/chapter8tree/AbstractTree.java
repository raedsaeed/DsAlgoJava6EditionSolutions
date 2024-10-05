package com.raed.dsa.chapter8tree;

import com.raed.dsa.chapter6stacksandqueue.impl.LinkedQueue;
import com.raed.dsa.chapter6stacksandqueue.impl.Queue;
import com.raed.dsa.chapter7list.ArrayList;
import com.raed.dsa.chapter7list.List;
import com.raed.dsa.chapter7list.Position;

/**
 * Created by Raed Saeed on 13/10/2021
 **/
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return getChildrenNum(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return getChildrenNum(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // get depth of tree from down to up (child to root) // number of all children
    public int depth(Position<E> position) {
        if (isRoot(position)) return 0;
        return 1 + depth(parent(position));
    }

    // get maximum height of subtree from the root itself to the last leaf
    public int height(Position<E> position) {
        int h = 0;
        for (Position<E> e : children(position)) {
            h = Math.max(h, height(e));
        }
        return h;
    }


    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     */
    private void preorderSubtree(Position<E> position, List<Position<E>> snapshot) {
        snapshot.add(position);
        for (Position<E> c : children(position)) {
            preorderSubtree(c, snapshot);
        }
    }


    /**
     * Returns an iterable collection of positions of the tree, reported in preorder.
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshots = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshots);
        }
        return snapshots;
    }


    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     **/
    private void postorderSubtree(Position<E> position, List<Position<E>> snapshot) {
        for (Position<E> c : children(position)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(position);     // for postorder, we add position p after exploring subtrees
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in postorder.
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshots = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshots);            // fill the snapshot recursively
        }
        return snapshots;
    }

    /**
     * Returns an iterable collection of positions of the tree in breadth first order.
     */
    public Iterable<Position<E>> breadthFirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> queue = new LinkedQueue<>();
            queue.enqueue(root());                                  // start with the root
            while (!queue.isEmpty()) {
                Position<E> position = queue.dequeue();             // remove from front of the queue
                snapshot.add(position);                             // report this position
                for (Position<E> child : children(position)) {
                    queue.enqueue(child);                           // add children to the back of queue
                }
            }
        }

        return snapshot;
    }
}

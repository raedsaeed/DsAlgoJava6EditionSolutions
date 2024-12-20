package com.raed.dsa.tree.linked;

import com.raed.dsa.chapter7list.ArrayList;
import com.raed.dsa.chapter7list.List;
import com.raed.dsa.chapter7list.Position;

/**
 * Created by Raed Saeed on 13/10/2021
 **/
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent)) return right(parent);
        else return left(parent);
    }

    @Override
    public int getChildrenNum(Position<E> p) throws IllegalArgumentException {
        int count = 0;
        if (left(p) != null) count++;
        if (right(p) != null) count++;
        return count;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) snapshot.add(left(p));
        if (right(p) != null) snapshot.add(right(p));
        return snapshot;
    }

    private void inorderSubtree(Position<E> position, List<Position<E>> snapshot) {
        if (left(position) != null) {
            inorderSubtree(left(position), snapshot);
        }
        snapshot.add(position);
        if (right(position) != null) {
            inorderSubtree(right(position), snapshot);
        }
    }

    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }
}

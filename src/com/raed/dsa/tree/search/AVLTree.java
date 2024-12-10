package com.raed.dsa.tree.search;


import com.raed.dsa.chapter7list.Position;
import com.raed.dsa.tree.linked.LinkedBinaryTree;

/**
 * Created by Raed Saeed on 07/12/2024
 */
public class AVLTree<E> extends LinkedBinaryTree<E> implements BalancedBinaryTree<E> {

    @Override
    public void balanceDelete(Position<E> position) {
        if (!isRoot(position))
            balance(parent(position));
    }

    @Override
    public void balanceInsert(Position<E> position) {
        balance(position);
    }

    private void balance(Position<E> position) {
        int newHeight = 0;
        int oldHeight = getHeight(position);
        while (oldHeight != newHeight && position != null) {
            if (!isBalanced(position)) {
                oldHeight = getHeight(position);
                Position<E> y = tallerChild(position);
                Position<E> x = tallerChild(y);
                position = restructure(x);
                computeHeight(left(position));
                computeHeight(right(position));
            }
            computeHeight(position);
            newHeight = getHeight(position);
            position = parent(position);
        }
    }

    private Position<E> tallerChild(Position<E> position) {
        Position<E> parent = parent(position);
        Position<E> left = left(position);
        Position<E> right = right(position);
        if (getHeight(left) > getHeight(right)) return left;
        if (getHeight(left) < getHeight(right)) return right;

        if (isRoot(position) || position == left(parent)) return left;
        return right;
    }

    private boolean isBalanced(Position<E> position) {
        return Math.abs(getHeight(left(position)) - getHeight(right(position))) <= 1;
    }

    private int getHeight(Position<E> position) {
        if (position == null) return 0;
        return validate(position).getAux();
    }

    private void computeHeight(Position<E> position) {
        if (position == null) return;
        validate(position).setAux(Math.max(getHeight(position), 1 + getHeight(left(position)) + getHeight(right(position))));
    }
}

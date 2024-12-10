package com.raed.dsa.tree.search;


import com.raed.dsa.chapter7list.Position;
import com.raed.dsa.tree.linked.LinkedBinaryTree;

/**
 * Created by Raed Saeed on 07/12/2024
 */
public class SplayTree<E> extends LinkedBinaryTree<E> implements BalancedBinaryTree<E> {
    @Override
    public void balanceInsert(Position<E> position) {
        while (!isRoot(position)) {
            Position<E> y = parent(position);
            Position<E> z = parent(y);

            if (z == null) { // perform zig rotation
                rotate(position);
            } else if ((position == left(y)) == (y == left(z))) { // perform zig-zig rotation
                rotate(y);
                rotate(position);
            } else { // perform zig-zag rotation
                rotate(position);
                rotate(position);
            }
        }
    }

    @Override
    public void balanceDelete(Position<E> position) {

    }
}

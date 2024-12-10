package com.raed.dsa.tree.search;


import com.raed.dsa.chapter7list.Position;

/**
 * Created by Raed Saeed on 07/12/2024
 */
public interface BalancedBinaryTree<E> {
    /**
     * Balance the tree after inserting new node
     * @param position the new child position
     */
    void balanceInsert(Position<E> position);


    /**
     * Balance the tree after deleting an existing node
     * @param position the sibling of child node
     */
    void balanceDelete(Position<E> position);
}

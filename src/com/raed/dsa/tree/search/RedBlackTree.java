package com.raed.dsa.tree.search;


import com.raed.dsa.chapter7list.Position;
import com.raed.dsa.tree.linked.LinkedBinaryTree;

/**
 * Created by Raed Saeed on 07/12/2024
 */
public class RedBlackTree<E> extends LinkedBinaryTree<E> implements BalancedBinaryTree<E> {
    @Override
    public void balanceInsert(Position<E> position) {
        if (!isRoot(position)) {
            makeRed(position);
            resolveDoubleRed(position);
        }
    }

    @Override
    public void balanceDelete(Position<E> position) {
        if (isRed(position)) {
            makeBlack(position);
        } else if (!isRoot(position)) {
            Position<E> sib = sibling(position);
            if (isInternal(sib) && (isBlack(sib)) || isInternal(left(sib)))
                resolveDoubleBlack(position);
        }
    }

    private void makeBlack(Position<E> position) {
        Node<E> node = validate(position);
        node.setAux(0);
    }

    private void makeRed(Position<E> position) {
        Node<E> node = validate(position);
        node.setAux(1);
    }

    private boolean isBlack(Position<E> position) {
        return validate(position).getAux() == 1;
    }

    private boolean isRed(Position<E> position) {
        return !isBlack(position);
    }

    private void setColor(Position<E> position, boolean isRed) {
        if (isRed) makeRed(position);
        else makeBlack(position);
    }

    private boolean hasRedChild(Position<E> position) {
        return isRed(left(position)) || isRed(right(position));
    }

    private void resolveDoubleRed(Position<E> x) {
        Position<E> y = parent(x);
        Position<E> uncle = sibling(y);
        Position<E> z = parent(y);

        if (isRed(y)) {
            if (isRed(uncle)) { // case 1 parent is red and uncle is red then recolor
                makeBlack(uncle);
                makeBlack(y);
                if (!isRoot(z)) {
                    makeRed(z);
                    resolveDoubleRed(z);
                }
            } else {            // case 2 parent is red and uncle is black then rotate
                Position<E> middle = restructure(x);
                makeBlack(middle);
                makeRed(left(middle));
                makeRed(right(middle));
            }
        }
    }

    private void resolveDoubleBlack(Position<E> x) {
        Position<E> parent = parent(x);
        Position<E> sibling = sibling(x);

        // case 1 x is black and sibling has red child then rotate over the red child
        if (hasRedChild(sibling)) {
            Position<E> redChild = isRed(left(sibling)) ? left(sibling) : right(sibling);
            Position<E> newMiddle = restructure(redChild);
            setColor(newMiddle, isRed(parent));
            makeBlack(left(newMiddle));
            makeBlack(right(newMiddle));
            return;
        }

        // case 2 x is black and sibling is black then recolor
        if (isBlack(sibling)) {
            makeRed(sibling);
            makeBlack(parent);

            if (!isRoot(parent))
                resolveDoubleBlack(parent);
        }

        // case 3 x is black and sibling is red
        if (isRed(sibling)) {
            rotate(sibling);
            makeBlack(sibling);
            makeRed(parent);
            resolveDoubleBlack(x); // from example code of the book
        }
    }
}

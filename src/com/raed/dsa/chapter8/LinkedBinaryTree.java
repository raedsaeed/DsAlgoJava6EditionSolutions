package com.raed.dsa.chapter8;

import com.raed.dsa.chapter7.Position;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 19/07/2022
 **/
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    protected Node<E> root = null;
    private int size;

    public LinkedBinaryTree() {

    }

    protected Node<E> validate(Position<E> position) {
        if (!(position instanceof Node<E> node))
            throw new IllegalArgumentException("Not valid position type");
        if (node.getParent() == node)
            throw new IllegalArgumentException("position is no longer in the tree");
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }


    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalStateException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) throw new IllegalStateException("Position already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalStateException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) throw new IllegalStateException("Position already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> tree1, LinkedBinaryTree<E> tree2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("P must be a leaf");
        size = tree1.size() + tree2.size();
        if (!tree1.isEmpty()) {
            tree1.root.setParent(node);
            node.setLeft(tree1.root);
            tree1.root = null;
            tree1.size = 0;
        }

        if (!tree2.isEmpty()) {
            tree2.root.setParent(node);
            node.setRight(tree2.root);
            tree2.root = null;
            tree2.size = 0;
        }
    }


    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (getChildrenNum(p) == 2) throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        if (child != null) {
            child.setParent(node.getParent());
        }

        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);
        return temp;
    }


    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    protected Node<E> createNode(E element, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(element, parent, left, right);
    }

    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            this.element = element;
            this.parent = parent;
            this.left = leftChild;
            this.right = rightChild;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }
}

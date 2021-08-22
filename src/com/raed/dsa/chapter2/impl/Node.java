package com.raed.dsa.chapter2.impl;

/**
 * Created by Raed Saeed on 8/19/2021
 **/
public class Node<E> {
    private E element;
    private Node<E> next;
    private Node<E> prev;

    public Node(E element, Node<E> next) {
        this(element, null, next);
    }

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}

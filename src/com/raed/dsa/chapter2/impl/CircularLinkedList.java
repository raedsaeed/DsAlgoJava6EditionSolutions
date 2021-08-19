package com.raed.dsa.chapter2.impl;

/**
 * Created by Raed Saeed on 8/19/2021
 **/
public class CircularLinkedList<T> {
    private Node<T> tail;
    private int size;

    public CircularLinkedList() {

    }

    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.addFirst("Raed");
        list.addLast("Saeed");

        System.out.println("First element " + list.getFirst());
        System.out.println("Last element " + list.getLast());
        list.printElements(10);

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            tail = new Node<>(element, null);
            tail.setNext(tail);
        } else {
            Node<T> newNode = new Node<>(element, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(T element) {
        addFirst(element);
        tail = tail.getNext();
    }

    private void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void printElements(int count) {
        for (int i = 0; i < count; i++) {
            rotate();
            System.out.println(tail.getElement());
        }
    }
}

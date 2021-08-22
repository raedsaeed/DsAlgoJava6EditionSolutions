package com.raed.dsa.chapter2.impl;

/**
 * Created by Raed Saeed on 8/19/2021
 **/
public class SingleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingleLinkedList() {
    }

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addLast("Raed");
        list.addLast("Ali");
        list.addLast("Ahmed");
        list.addLast("Saeed");
        System.out.println("Normal size " + list.getNormalSize());
        System.out.println("Size " + list.size);
        list.printElements();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(T element) {
        head = new Node<>(element, head);
        if (isEmpty()) tail = head;
        size++;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        tail = newNode; // set the object reference to the tail
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        T element = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) tail = null;

        return element;
    }

    public void printElements() {
        Node<T> printer = head;
        while (printer != null) {
            System.out.println(printer.getElement());
            printer = printer.getNext();
        }
    }

    public int getNormalSize() {
        int size = 0;
        Node<T> item = head;
        if (item == null) return size;
        while (item != null) {
            size++;
            item = item.getNext();
        }
        return size;
    }
}

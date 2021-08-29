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
        list.addLast("Naser");
        list.addLast("Saeed");

        CircularLinkedList<String> l2 = new CircularLinkedList<>();
        l2.addFirst("Raed");
        l2.addLast("Naser");
        l2.addLast("Saeed");

        System.out.println("Has same sequence " + list.hasSameSequence(l2));
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

    public Node<T> removeFirst() {
        if (tail == null) return null;
        Node<T> firstNode = tail.getNext();
        Node<T> secondFirst = firstNode.getNext();
        tail.setNext(secondFirst);
        size--;
        return firstNode;
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

    public int getNormalSize() {
        if (tail == null) return size;
        Node<T> first = tail.getNext();
        Node<T> last = tail;
        int size = 0;

        while (first != null) {
            size++;
            first = first.getNext();
            if (first == last.getNext()) break;
        }

        return size;
    }

    public boolean hasSameSequence(CircularLinkedList<T> other) {
        if (tail == null || other.tail == null) return false;

        Node<T> first = tail.getNext();
        Node<T> firstStartingPoint = null;
        Node<T> last = tail;
        Node<T> otherStartingPoint = other.tail.getNext();
        Node<T> otherLast = other.tail;

        while (first != null) {
            if (otherStartingPoint != null && first.getElement() == otherStartingPoint.getElement()) {
                firstStartingPoint = first;
                break;
            }

            first = first.getNext();
            if (first == last.getNext()) break;
        }

        while (firstStartingPoint != null && otherStartingPoint != null && firstStartingPoint != last.getNext() && otherStartingPoint != otherLast.getNext()) {
            if (firstStartingPoint.getElement() != otherStartingPoint.getElement()) return false;

            firstStartingPoint = firstStartingPoint.getNext();
            otherStartingPoint = otherStartingPoint.getNext();
        }

        return true;
    }
}

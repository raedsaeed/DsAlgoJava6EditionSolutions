package com.raed.dsa.chapter2oodesign.impl;

/**
 * Created by Raed Saeed on 8/19/2021
 **/
public class SingleLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingleLinkedList() {
    }

    public static void main(String[] args) {
        SingleLinkedList<String> list1 = new SingleLinkedList<>();
        SingleLinkedList<String> list2 = new SingleLinkedList<>();
        list1.addFirst("Raed");
        list1.addLast("Nasser");
        list1.addLast("Ali");
        list2.addLast("Ahmed");
        list2.addLast("Saeed");

        System.out.println("List contains Raed : " + list1.contain("Raed"));
        System.out.println("List contains Raeds : " + list1.contain("Raeds"));

        list1.concatenate(list2);

        list1.reverse();

        list1.printElements();
        System.out.println("Deleting Last............" + list1.removeLast());
        System.out.println("Deleting Last............" + list1.removeLast());
        System.out.println("Deleting Last............" + list1.removeLast());
        list1.printElements();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) return null;
        return head.element;
    }

    @Override
    public T getLast() {
        if (isEmpty()) return null;
        return tail.element;
    }

    @Override
    public void addFirst(T element) {
        head = new Node<>(element, head);
        if (isEmpty()) tail = head;
        size++;
    }

    @Override
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

    @Override
    public T removeLast() {
        if (isEmpty()) return null;

        if (size() == 1) {
            T element = head.element;
            head = tail = null;
            size--;
            return element;
        }

        Node<T> walk = head;
        while (walk.getNext() != null && walk.getNext() != tail) {
            walk = walk.getNext();
        }
        walk.setNext(null);
        T element = tail.element;
        tail = walk;
        size--;
        return element;
    }

    @Override
    public boolean contain(T t) {
        if (isEmpty()) return false;

        Node<T> walk = head;
        while (walk != null) {
            if (walk.element == t) return true;
            walk = walk.getNext();
        }
        return false;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T element = head.element;
        head = head.getNext();
        size--;

        if (isEmpty()) tail = null;

        return element;
    }

    @Override
    public void printElements() {
        Node<T> printer = head;
        while (printer != null) {
            System.out.println(printer.element);
            printer = printer.getNext();
        }
    }

    /**
     * Write a method concatenate two single lists
     */

    public void concatenate(SingleLinkedList<T> newList) {
        if (isEmpty()) {
            this.head = newList.head;
        } else {
            tail.setNext(newList.head);
        }
        this.tail = newList.tail;
        size += newList.size;
        newList.head = null;
    }

    public T getByIndex(int index) {
        if (index < 0 || index > size())
            throw new IllegalArgumentException("Index " + index + ", List size is " + size);
        if (isEmpty()) return null;
        Node<T> node = head;
        for (int i = 0; i != index; i++) {
            node = node.getNext();
        }
        return node.element;
    }

    public void swap(T first, T second) {
        if (first == null || second == null) return;

        Node<T> prevX = null;
        Node<T> currX = head;
        while (currX != null && currX.element != first) {
            prevX = currX;
            currX = currX.getNext();
        }

        Node<T> prevY = null;
        Node<T> currY = head;
        while (currY != null && currY.element != second) {
            prevY = currY;
            currY = currY.getNext();
        }

        if (currX == null || currY == null) {
            return;
        }

        if (prevX == null) {
            head = currY;
        } else {
            prevX.setNext(currY);
        }

        if (prevY == null) {
            head = currX;
        } else {
            prevY.setNext(currX);
        }

        Node<T> temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);
    }


    @Override
    public void reverse() {
        Node<T> current = tail = head;
        Node<T> prev = null;
        Node<T> next;

        while (current != null && current.element != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;
    }

    @Override
    public void clear() {
        while (size() > 0) {
            removeFirst();
        }
        head = tail = null;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}

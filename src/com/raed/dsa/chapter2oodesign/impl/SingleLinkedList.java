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
        list1.concatenate(list2);

        list1.reverse();

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
        return head.getElement();
    }

    @Override
    public T getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
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
        return null;
    }

    @Override
    public boolean contain(T t) {
        return false;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T element = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) tail = null;

        return element;
    }

    @Override
    public void printElements() {
        Node<T> printer = head;
        while (printer != null) {
            System.out.println(printer.getElement());
            printer = printer.getNext();
        }
    }

    /**
     * Write a method concatenate two single lists
     *
     * @return SingleLinkedList
     */

    public SingleLinkedList<T> concatenate(SingleLinkedList<T> newList) {
        if (isEmpty()) {
            this.head = newList.head;
        } else {
            tail.setNext(newList.head);
        }
        this.tail = newList.tail;
        size += newList.size;
        return this;
    }

    public Node<T> getByIndex(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Index " + index + ", List size is " + size);
        if (isEmpty()) return null;
        Node<T> node = head;
        for (int i = 0; i != index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void swap(T first, T second) {
        if (first == null || second == null) return;

        Node<T> prevX = null;
        Node<T> currX = head;
        while (currX != null && currX.getElement() != first) {
            prevX = currX;
            currX = currX.getNext();
        }

        Node<T> prevY = null;
        Node<T> currY = head;
        while (currY != null && currY.getElement() != second) {
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

    public Node<T> findElement(T element) {
        Node<T> current = head;
        while (current != null && current.getElement() != element) {
            current = current.getNext();
        }

        return current;
    }

    @Override
    public void reverse() {
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next;

        while (current != null && current.getElement() != null) {
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
        head = null;
    }
}

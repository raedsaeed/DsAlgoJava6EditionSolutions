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
        SingleLinkedList<String> list1 = new SingleLinkedList<>();
        SingleLinkedList<String> list2 = new SingleLinkedList<>();
        list1.addFirst("Raed");
        list1.addLast("Nasser");
        list1.addLast("Ali");
        list2.addLast("Ahmed");
        list2.addLast("Saeed");
        list1.concatenate(list2);
        list1.swap(1, 3);
        list1.printElements();
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

    public void swap(int first, int second) {
        if (first < 0 || first > size || second < 0 || second > size)
            throw new IllegalArgumentException("First " + first + ", second " + second + ", List size is " + size);

        if (second < first) swap(second, first);

        Node<T> preFirst;
        Node<T> firstNode;
        Node<T> secondNode;
        Node<T> preSecondNode = null;

        if (first == 0) {
            preFirst = getByIndex(second - 1);
            firstNode = head;
            secondNode = getByIndex(second);
//            swap(preFirst, secondNode, firstNode);
        } else {
            preFirst = getByIndex(first - 1);
            firstNode = getByIndex(first);
            preSecondNode = getByIndex(second - 1);
            secondNode = getByIndex(second);
            swap(preFirst, firstNode, preSecondNode, secondNode);
        }

    }

    private void swap(Node<T> preFirst, Node<T> first, Node<T> preSecond, Node<T> second) {
        Node<T> temp = second.getNext();
        preFirst.setNext(second);
        second.setNext(first.getNext());
        preSecond.setNext(first);
        first.setNext(temp);

//        second.setNext(first);
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

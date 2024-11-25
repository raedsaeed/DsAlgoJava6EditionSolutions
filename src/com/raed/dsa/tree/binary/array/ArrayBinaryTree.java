package com.raed.dsa.tree.binary.array;


import com.raed.dsa.chapter7list.ArrayList;
import com.raed.dsa.chapter7list.List;

/**
 * Created by Raed Saeed on 13/11/2024
 */
public class ArrayBinaryTree<T> extends AbstractBinaryTree<T> {
    private final List<T> list = new ArrayList<>();

    public T addRoot(T t) {
        if (t == null) throw new IllegalArgumentException("Element can't be null");
        if (!isEmpty()) throw new IllegalArgumentException("Root already exist");
        list.add(t);
        return t;
    }

    public T addLeft(int index, T element) {
        if (size() == 0) return addRoot(element);
        int left = 2 * index + 1;
        list.add(left, element);
        return element;
    }

    public T addRight(int index, T element) {
        if (size() == 0) return addRoot(element);
        int right = 2 * index + 2;
        list.add(right, element);
        return element;
    }

    public void set(int index, T element) {
        check(index);
        list.set(index, element);
    }

    @Override
    public T getElement(int index) {
        check(index);
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterable<Integer> children(int index) {
        ArrayList<Integer> children = new ArrayList<>();
        if (hasLeft(index))
            children.add(left(index));

        if (hasRight(index))
            children.add(right(index));
        return children;
    }

    @Override
    public int getChildrenNumber(int index) {
        int count = 0;
        if (hasLeft(index)) count++;
        if (hasRight(index)) count++;
        return count;
    }

    @Override
    public int parent(int index) throws IndexOutOfBoundsException {
        check(index);
        return (index - 1) / 2;
    }

    private void check(int index) {
        if (index < 0 || index > size()) throw new IllegalArgumentException("Invalid index " + index);
    }
}

package com.raed.dsa.chapter7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Raed Saeed on 26/09/2021
 **/
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int size = 0;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int position) throws ArrayIndexOutOfBoundsException {
        checkIndex(position, size);
        return data[position];
    }

    @Override
    public boolean add(T element) {
        if (size == data.length) {
            grow();
        }
        data[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int position, T element) throws ArrayIndexOutOfBoundsException {
        checkIndex(position, size + 1);
        System.arraycopy(data, position, data, position + 1, size - position);
        data[position] = element;
        size++;
    }

    @Override
    public T set(int position, T element) throws ArrayIndexOutOfBoundsException {
        checkIndex(position, size);
        T temp = get(position);
        data[position] = element;
        return temp;
    }

    @Override
    public T remove(int position) throws ArrayIndexOutOfBoundsException {
        checkIndex(position, size);
        T temp = get(position);
        fastRemove(position);
        return temp;
    }

    @Override
    public boolean remove(T element) {
        Object[] arr = data;
        int index = 0;
        int size = this.size;
        find:
        {
            if (element == null) {
                for (; index < size; index++)
                    if (arr[index] == null) break find;

            } else {
                for (; index < size; index++)
                    if (element.equals(arr[index])) break find;
            }
            return false;
        }
        fastRemove(index);
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public void trimToSize() {
        if (size > DEFAULT_CAPACITY) {
            data = Arrays.copyOf(data, size);
        }
    }

    protected void checkIndex(int i, int n) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    private void grow() {
        // 1 -> 0001
        // (1 << 1) -> 0010 -> 2
        // (2 << 1) -> 0100 -> 4
        // (4 << 1) -> 1000 -> 8
        data = Arrays.copyOf(data, (size + (size << 1)));
    }

    private void fastRemove(int i) {
        int newSize;     // new size
        // srcPosition specify the start of copying from source --> بمعني تاني انه بيختار المكان اللي هيبدأ منه النسخ
        // فهنا قال إنه هيبدأ النسخ من بعد العنصر اللي عايز يشيله
        // destPos المكان اللي هيبدأ فيه النسخ فحدد المكان بتاع العنصر نفسه .. يعني هو هياخد من بعد العنصر ينسخ يحط من مكان العنصر يارب تبقي فاهم لما تشوفها تاني
        if ((newSize = size - 1) > i) {
            System.arraycopy(data, i + 1, data, i, newSize - i);
        }
        data[size = newSize] = null;
    }

    private class ArrayIterator implements Iterator<T> {
        private int j;
        private boolean isRemovable = false;

        @Override
        public boolean hasNext() {
            return j < size;
        }

        @Override
        public T next() {
            if (j == size) throw new NoSuchElementException("No next element");
            isRemovable = true;
            return data[j++];
        }

        @Override
        public void remove() {
            if (!isRemovable) throw new IllegalStateException("Nothing to remove");
            ArrayList.this.remove(data[j - 1]);
            j--;
            isRemovable = false;
        }

    }
}

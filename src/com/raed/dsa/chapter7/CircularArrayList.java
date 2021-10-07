package com.raed.dsa.chapter7;

/**
 * Created by Raed Saeed on 29/09/2021
 **/
// todo CircularArrayList not completed
public class CircularArrayList<T> extends ArrayList<T> {
    private int first = 0;

    public CircularArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public boolean add(T element) {
        if (size == data.length) {
            grow();
        }
        int available = (first + size) % data.length;
        data[available] = element;
        size++;
        return true;
    }

    @Override
    public T get(int position) throws ArrayIndexOutOfBoundsException {
        int available = (first + position) % data.length;
        return data[position];
    }

    @Override
    public T remove(int position) throws ArrayIndexOutOfBoundsException {
        // remove position 1
        // make value at 0 = null
        // increase value of fast by one to be equivalent to next 0

//        first = (first + position) % data.length;
//        T temp = data[first];
//        data[position] = null;
//        first++;
//        size--;
//        return temp;

        T temp = data[position];
        data[position] = null;
        size--;
        return temp;
    }
}

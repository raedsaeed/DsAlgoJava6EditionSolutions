package com.raed.dsa.chapter7;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 26/09/2021
 **/
public interface Collections<T> {
    int size();

    boolean isEmpty();

    Object[] toArray();

    Iterator<T> iterator();

    void clear();
}

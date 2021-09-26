package com.raed.dsa.chapter7;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Raed Saeed on 26/09/2021
 **/
public interface Collections<T> extends Iterable<T>{
    int size();

    boolean isEmpty();

    Object[] toArray();

    Iterator<T> iterator();

    @Override
    default void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    default Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    void clear();
}

package com.raed.dsa.chapter7;

/**
 * Created by Raed Saeed on 26/09/2021
 **/
public interface Position<T> {
    T getElement() throws IllegalStateException;
}

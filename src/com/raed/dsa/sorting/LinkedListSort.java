package com.raed.dsa.sorting;


import com.raed.dsa.chapter7list.Position;
import com.raed.dsa.chapter7list.PositionalList;

/**
 * Created by Raed Saeed on 12/11/2024
 */
public class LinkedListSort {
    public static void sort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);

            Integer value = pivot.getElement();
            if (value > marker.getElement())
                marker = pivot;
            else {
                Position<Integer> walk = marker;
                while (walk != list.first() &&
                        value < list.before(walk).getElement())
                    walk = list.before(walk);

                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }
}

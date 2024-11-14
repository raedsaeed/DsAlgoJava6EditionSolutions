package com.raed.dsa.heap;


import java.util.Comparator;

/**
 * Created by Raed Saeed on 14/11/2024
 */
public class HeapMainTest {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{13, 10, 9, 16, 3, 4, 2, 5, 11, 7, 1, 6, 8, 12, 14};
        HeapList<Integer> heap = new HeapList<>(array, Comparator.naturalOrder());
        while (!heap.isEmpty()) {
            System.out.println(heap.peek());
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(9);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.front());
            System.out.println(priorityQueue.peek());
        }
    }
}

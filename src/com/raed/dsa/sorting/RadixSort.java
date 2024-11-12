package com.raed.dsa.sorting;


import com.raed.dsa.chapter7list.ArrayList;
import com.raed.dsa.chapter7list.LinkedPositionalList;

import java.util.Random;

/**
 * Created by Raed Saeed on 10/11/2024
 */

@SuppressWarnings("UNCHECKED")
public class RadixSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        int count = 1000_00;
        Random random = new Random(Integer.MAX_VALUE);
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }


        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        sort(array);
        for (int i : array) {
            System.out.println(i + ",");
        }
    }

    public static void sort(int[] arr) {
        int maxDigit = findMaxDigit(findMaxNumber(arr));
        for (int pow = 0; pow < maxDigit; pow++) {
            LinkedPositionalList<Integer>[] list = new LinkedPositionalList[10];

            for (int j : arr) {
                int index = (j / (int) Math.pow(10, pow)) % 10;
                if (list[index] == null)
                    list[index] = new LinkedPositionalList<>();

                list[index].addLast(j);
                LinkedListSort.sort(list[index]);
            }

            int count = 0;
            for (LinkedPositionalList<Integer> linkedPositionalList : list) {
                if (linkedPositionalList != null) {
                    for (Integer element : linkedPositionalList) {
                        arr[count++] = element;
                    }
                }
            }
        }
    }

    private static int findMaxNumber(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int max = 0;
        for (int item : arr) {
            max = Math.max(max, item);
        }
        return max;
    }

    private static int findMaxDigit(int number) {
        if (number == 0) return 0;
        int count = 0;
        int result = number;
        while (result > 0) {
            result /= 10;
            count++;
        }
        return count;
    }
}

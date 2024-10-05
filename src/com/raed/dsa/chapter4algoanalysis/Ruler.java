package com.raed.dsa.chapter4algoanalysis;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Raed Saeed on 9/4/2021
 **/
public class Ruler {
    public static void main(String[] args) {
//        drawRuler(2, 3);
        Random random = new Random();
        int[] data = new int[4];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(5);
        }

        System.out.println("Array before sort " + Arrays.toString(data));
        Arrays.sort(data);
        System.out.println("Array after sort " + Arrays.toString(data));
        int indexOf3 = binarySearch(data, 3, 0, data.length - 1);
        System.out.println("Index is " + indexOf3);
    }

    private static int max(int[] data, int low, int max) {
        // base test
        if (low == data.length - 1) {
            return max;
        }

        max = Math.max(data[low], max);

        max = max(data, low + 1, max);

        return max;
    }

    private static int binarySearch(int[] data, int target, int low, int high) {
        // test base
        if (low <= high) {
            int mid = (low + high) / 2;

            if (target > data[mid]) {
                return binarySearch(data, target, mid + 1, high);
            } else if (target < data[mid]) {
                return binarySearch(data, target, low, mid - 1);
            } else if (target == data[mid]) {
                return mid;
            }
        }
        return -1;
    }

    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0); // draw inch 0 line and label
        for (int j = 1; j <= nInches; j++) {
            drawInterval(majorLength - 1); // draw interior ticks for inch
            drawLine(majorLength, j); // draw inch j line and label
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) { // otherwise, do nothing
            drawInterval(centralLength - 1); // recursively draw top interval
            drawLine(centralLength); // draw center tick line (without label)
            drawInterval(centralLength - 1); // recursively draw bottom interval
        }
    }

    private static void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++)
            System.out.print("-");
        if (tickLabel >= 0)
            System.out.print(" " + tickLabel);
        System.out.print("\n");
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }
}

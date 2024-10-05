package com.raed.dsa.chapter1javaprimer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Raed Saeed on 8/16/2021
 **/
class ChartReader {
    public static void main(String[] args) throws IOException {

        File file = new File("text.txt");
        Scanner fileContainer = new Scanner(file);
        Map<Character, Integer> chart = new HashMap<>();
        while (fileContainer.hasNextLine()) {
            char[] line = fileContainer.nextLine().toLowerCase().toCharArray();

            for (char c : line) {
                if (!Character.isLetter(c))
                    continue;

                if (!chart.containsKey(c)) {
                    chart.put(c, 1);
                } else {
                    int count = chart.get(c);
                    chart.put(c, ++count);
                }
            }
        }

        chart.keySet().forEach(key -> {
            System.out.println(key + "-" + chart.get(key));
        });
    }
}

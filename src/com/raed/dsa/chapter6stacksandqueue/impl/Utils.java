package com.raed.dsa.chapter6stacksandqueue.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raed Saeed on 19/09/2021
 **/
public class Utils {
    public static void main(String[] args) {
        permute(3, new ArrayList<>(List.of('a', 'b', 'c')), new ArrayList<>());
        System.out.println(postfix("((5+2) * (8 - 3)) / 4"));
    }

    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>();
        int j = html.indexOf('<'); // find first ’<’ character (if any)
        while (j != -1) {
            int k = html.indexOf('>', j + 1); // find next ’>’ character
            if (k == -1)
                return false; // invalid tag
//            String tag = html.split(" ")[0];
            String tag = html.substring(j + 1, k); // strip away < >
            if (tag.split(" ").length > 0) {
                tag = tag.split(" ")[0];
            }
            if (!tag.startsWith("/")) // this is an opening tag
                buffer.push(tag);
            else { // this is a closing tag
                if (buffer.isEmpty())
                    return false; // no tag to match
                if (!tag.substring(1).equals(buffer.pop()))
                    return false; // mismatched tag
            }
            j = html.indexOf('<', k + 1); // find next ’<’ character (if any)
        }
        return buffer.isEmpty(); // were all opening tags matched?
    }

    public static String postfix(String equation) {
        StringBuilder expression = new StringBuilder();
        LinkedStack<Character> operators = new LinkedStack<>();
        int i = 0;
        while (i < equation.length()) {
            char ch = equation.charAt(i);

            if (ch == ' ') {
                i++;
                continue;
            }

            if (ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '(') {
                operators.push(ch);
                i++;
                continue;
            }

            if (ch == ')') {
                while (operators.top() != '(') {
                    expression.append(operators.pop());
                }
                operators.pop();
            } else {
                expression.append(ch);
            }
            i++;
        }

        while (!operators.isEmpty()) {
            expression.append(operators.pop());
        }

        return expression.toString();
    }

    public static String getSubsets(Object[] arr) {
        int size = arr.length;
        int setCount = (int) Math.pow(2, size);
        int counter;
        int j;
        for (counter = 0; counter < setCount; counter++) {
            String comma = "";
            StringBuilder builder = new StringBuilder("{");
            for (j = 0; j < size; j++) {
                if ((counter & (1 << j)) > 0) {
                    builder.append(comma)
                            .append(arr[j]);
                    comma = ",";
                }

                if (j == size - 1) {
                    builder.append("}");
                }
            }
            System.out.println(builder);
        }
        return "";
    }

    public static void getSubsetsUsingStackAndQueue(Object[] arr) {
        int size = arr.length;
        int setCount = (int) Math.pow(2, size);
        Stack<Object> stack = new LinkedStack<>();
        Queue<Object> queue = new LinkedQueue<>();

//        for (counter = 0; counter < setCount; counter++) {
//            String comma = "";
//            StringBuilder builder = new StringBuilder("{");
//            for (j = 0; j < size; j++) {
//                if ((counter & (1 << j)) > 0) {
//                    builder.append(comma)
//                            .append(arr[j]);
//                    comma = ",";
//                }
//
//                if (j == size - 1) {
//                    builder.append("}");
//                }
//            }
//            System.out.println(builder);
//        }
    }

    public static void getAllPermutation(Object[] arr, int index) {
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permute(arr, index + 1);
            swap(arr, i, index);
        }

        if (index == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void permute(Object[] arr, int k) {
        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            permute(arr, k + 1);
            swap(arr, i, k);
        }

        if (k == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void swap(Object[] arr, int first, int second) {
        Object temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static <T> void permute(int k, ArrayList<T> set, ArrayList<T> contains) {
        for (int i = 0; i < set.size(); i++) {
            T e = set.get(i);
            set.remove(i);
            contains.add(e);

            if (k == 1) {
                System.out.println(Arrays.toString(contains.toArray()));
            } else {
                permute(k - 1, set, contains);
            }

            set.add(i, e);
            contains.remove(e);
        }
    }
}

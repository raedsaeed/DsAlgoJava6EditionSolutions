package com.raed.dsa.chapter4algoanalysis;

import java.util.Arrays;

/**
 * Created by Raed Saeed on 9/13/2021
 **/
public class Chapter5Solutions {
    public static void main(String[] args) {
        // calculate harmonic number of given n numbers
//        System.out.println("Sum is " + calculateHarmonicNumbers(7));


        // convert string digit to integer
//        int number = convertStringToInt("1", 0) + 15;
//        System.out.println("number is " + number);


        // calcualte power number with square
//        int base = 5;
//        int power = 0;
//        System.out.println(base + " power " + power + " -> " + power(base, power));


        // sum two dimen array
//        int[][] twoDimen = {
//                {5, 5, 5},
//                {0, 5, 5}
//        };
//
//        System.out.println("Sum of array is " + sumMatrix(twoDimen));


        // log2^8
//        System.out.println("Log 8 base 2 -> " + calculateLog(5, 25));


//         find unique item
//        int[] uniqueList = {4, 1, 3, 4, 3};
//        System.out.println("Unique item is " + findUniqueItemUsingRecursion(uniqueList, 0));


        // find product of two positive integers using sum and sub
//        System.out.println("Product of 2 and 5 -> " + productUsingSumAndSub(5, 2));


        // C.17 Write a short recursive Java method that takes a character string s and outputs its
        //reverse.
//        String phraseToRevers = "pots&pans";
//        System.out.println(phraseToRevers + " -> " + reverse(phraseToRevers));


        // C-5.18 Write a short recursive Java method that determines if a string s is a palindrome,
        // that is, it is equal to its reverse.
//        String isPalindromePhrase = "racecar";
//        System.out.println(isPalindromePhrase + " -> " + isPalindromes(isPalindromePhrase));


        /* C-5.20 Write a short recursive Java method that rearranges an array of integer values so
         * that all the even values appear before all the odd values.
         */
//        int[] numbers = {1, 3, 3, 2, 5, 7, 8};
//        rearrange(numbers, 0, 0);
//        System.out.println("After rearrange " + Arrays.toString(numbers));

        /*
         * C-5.21 Given an unsorted array, A, of integers and an integer k, describe a recursive
         * algorithm for rearranging the elements in A so that all elements less than or equal
         * to k come before any elements larger than k.
         */
//        int[] numbersToSort = {8, 2, 9, 4, 3, 6};
//        sortByK(numbersToSort, 0, 0, 5);
//        System.out.println("After Sort " + Arrays.toString(numbersToSort));

        int[] numbersToGetSumPairs = {1, 2, 3, 4, 5, 6};
        int sum = 5;
        System.out.println("Pairs to equals to " + sum + " -> " + Arrays.toString(pairs(numbersToGetSumPairs, 0, sum)));
    }

    private static double calculateHarmonicNumbers(double n) {
        // test base case
        double result;
        if (n < 2) {
            result = 1;
            return result;
        }

        result = 1 / n + calculateHarmonicNumbers(n - 1);
        return result;
    }

    private static int convertStringToInt(String digit, int index) {
        int x = 0;
        int length = digit.length();
        if (index < length) {
            x = digit.charAt(index) - '0';
            x = (int) (x * Math.pow(10, length - 1 - index) + convertStringToInt(digit, ++index));
        }

        return x;
    }

    private static int power(int base, int pow) {
        int result = 1;
        int mid = pow / 2;
        for (int i = mid; i >= 1; i--) {
            result = base * result;
        }

        if (pow % 2 == 1) {
            result = base * result;
        }

        return result * result;
    }

    private static int sumMatrix(int[][] arr) {
        return sumMatrix(arr, 0, 0);
    }

    private static int sumMatrix(int[][] arr, int row, int column) {
        int sum = 0;
        if (row >= arr.length) {
            return sum;
        }

        if (column >= arr[row].length) {
            return sum + sumMatrix(arr, ++row, 0);
        }

        sum = sum + arr[row][column];
        return sum + sumMatrix(arr, row, ++column);
    }

    private static double calculateLog(double b, double a) {
        if (b > a) {
            return 0;
        }

        return 1 + calculateLog(b, a / b);
    }

    /**
     * C-5.12 Describe an efficient recursive algorithm for solving the element uniqueness
     * problem, which runs in time that is at most O(n2) in the worst case without using
     * sorting.
     */
    private static int findUniqueItem(int[] arr) {
        return findUniqueItemUsingRecursion(arr, 0);
    }

    private static int findUniqueItemUsingLoops(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        index = -1;
                        break;
                    } else {
                        index = i;
                    }
                }
            }

            if (index != -1) {
                return arr[index];
            }
        }

        return -1;
    }

    private static int findUniqueItemUsingRecursion(int[] arr, int index) {
        int item = -1;

        // to end the loop
        if (index >= arr.length) {
            return item;
        }

        for (int i = 0; i < arr.length; i++) {
            item = i;
            if (index != i) {
                if (arr[index] == arr[i]) {
                    item = -1;
                    break;
                }
            }
        }

        if (item == -1) {
            if (index + 1 < arr.length) {
                return findUniqueItemUsingRecursion(arr, ++index);
            } else {
                return item;
            }
        }
        return arr[index];
    }


    private static int productUsingSumAndSub(int m, int n) {
        int result = 0;

        if (n > 0) {
            return result + m + productUsingSumAndSub(m, n - 1);
        }

        return 0;
    }

    // C 5.17
    private static String reverse(String phrase) {
        return new String(reverseString(phrase.toCharArray(), 0, phrase.length() - 1));
    }

    private static char[] reverseString(char[] phrase, int low, int high) {
        if (low >= high) {
            return phrase;
        }

        char temp = phrase[low];
        phrase[low] = phrase[high];
        phrase[high] = temp;
        return reverseString(phrase, ++low, --high);
    }

    // C-5.18 Write a short recursive Java method that determines if a string s is a palindrome,
    //that is, it is equal to its reverse
    private static boolean isPalindromes(String phrase) {
        return isPalindromes(phrase, 0, phrase.length() - 1);
    }

    private static boolean isPalindromes(String phrase, int low, int high) {
        if (low >= high) {
            return true;
        }

        if (phrase.charAt(low) == phrase.charAt(high)) {
            return isPalindromes(phrase, ++low, --high);
        }

        return false;
    }

    // C-5.20 Write a short recursive Java method that rearranges an array of integer values so
    //        that all the even values appear before all the odd values.
    private static void rearrange(int[] arr, int low, int high) {
        if (low <= high) {
            if (arr[low] % 2 == 0 && arr[high] % 2 == 1) {
                rearrange(arr, ++low, --high);
            } else if (arr[low] % 2 == 0) {
                rearrange(arr, ++low, high);
            } else if (arr[high] % 2 == 0) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
                rearrange(arr, ++low, --high);
            } else {
                rearrange(arr, low, --high);
            }
        }
    }

    /**
     * C-5.21 Given an unsorted array, A, of integers and an integer k, describe a recursive
     * algorithm for rearranging the elements in A so that all elements less than or equal
     * to k come before any elements larger than k.
     */
    private static void sortByK(int[] arr, int index, int counter, int k) {
        if (index < arr.length - 1) {
            if (arr[index] < k) {  // this fine no need to swap with the last element
                int temp = arr[index];
                arr[index] = arr[counter];
                arr[counter] = temp;
                sortByK(arr, ++index, ++counter, k);
            } else {
                sortByK(arr, ++index, counter, k);
            }
        }
    }

    /**
     * C-5.22 Suppose you are given an array, A, containing n distinct integers that are listed
     * in increasing order. Given a number k, describe a recursive algorithm to find two
     * integers in A that sum to k, if such a pair exists. What is the running time of your
     * algorithm?
     */
    private static int[] pairs(int[] arr, int index, int sum) {
        if (index >= arr.length) {
            return new int[]{};
        }

        int secondPairIndex = binarySearch(arr, sum - arr[index], 0, arr.length - 1);

//        for (int i = 0; i < arr.length; i++) {
//            if (sum == arr[index] + arr[i]) {
//                secondPairIndex = i;
//            } else if (sum < arr[i] + arr[index]) {
//                break;
//            }
//        }


        if (secondPairIndex != -1) {
            return new int[]{arr[index], arr[secondPairIndex]};
        }

        return pairs(arr, ++index, sum);
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
}

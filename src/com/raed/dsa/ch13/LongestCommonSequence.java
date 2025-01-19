package com.raed.dsa.ch13;


/**
 * Created by Raed Saeed on 24/12/2024
 */

public class LongestCommonSequence {
    public static void main(String[] args) {
        char[] y = "abcbdab".toCharArray();
        char[] x = "bdcab".toCharArray();
        int[][] result = longestCommonSequence(x, y);
        System.out.println(constructLongestCommonSequence(x, y, result));
    }

    public static int[][] longestCommonSequence(char[] x, char[] y) {
        int n = x.length;
        int m = y.length;
        int[][] l = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (x[i] == y[k])
                    l[i + 1][k + 1] = 1 + l[i][k];
                else
                    l[i + 1][k + 1] = Math.max(l[i][k + 1], l[i + 1][k]);
            }
        }
        return l;
    }

    public static String constructLongestCommonSequence(char[] x, char[] y, int[][] l) {
        StringBuilder builder = new StringBuilder();
        int i = x.length;
        int j = y.length;
        while (l[i][j] > 0) {
            if (x[i - 1] == y[j - 1]) {
                builder.append(x[i - 1]);
                i--;
                j--;
            } else if (l[i - 1][j] >= l[i][j - 1])
                i--;
            else j--;
        }
        return builder.reverse().toString();
    }
}

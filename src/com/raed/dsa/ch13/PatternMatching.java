package com.raed.dsa.ch13;


import com.raed.dsa.map.ChainHashMap;

/**
 * Created by Raed Saeed on 24/12/2024
 */
public class PatternMatching {
    public static void main(String[] args) {
        String pattern = "abc";
        String text = "abclsfabcsill";
        System.out.println(search(pattern, text));
    }

    private static int search(String pattern, String text) {
//        return boyerMoreSearch(pattern.toCharArray(), text.toCharArray());
        return KMP(pattern.toCharArray(), text.toCharArray());
    }

    private static int naiveSearch(char[] pattern, char[] text) {
        int n = text.length;
        int k = pattern.length;
        for (int i = 0; i < n - k; i++) {
            for (int j = 0; j < k; j++) {
                if (pattern[j] == text[i + j]) {
                    if (j == k - 1) return i;
                }
            }
        }
        return -1;
    }

    private static int boyerMoreSearch(char[] pattern, char[] text) {
        int n = text.length;
        int k = pattern.length;

        ChainHashMap<Character, Integer> map = new ChainHashMap<>();
        for (char c : text) {
            map.put(c, -1);
        }

        for (int j = 0; j < k; j++) {
            map.put(pattern[j], j);
        }

        int j = k - 1;
        int i = k - 1;
        while (i < n) {
            while (pattern[j] == text[i]) {
                j--;
                i--;

                if (j < 0) return i + 1;
            }

            int jump = k - Math.min(j, 1 + map.get(text[i]));
            i += jump;
        }
        return -1;
    }

    private static int KMP(char[] pattern, char[] text) {
        int[] lps = longestPrefixSuffix(pattern);
        int i = 0;
        int k = 0;
        while (i < text.length) {
            if (pattern[k] == text[i]) {
                i++;
                k++;
                if (k == pattern.length - 1) return i - k;
            } else if (k > 0) {
                k = lps[k - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    private static int[] longestPrefixSuffix(char[] pattern) {
        int[] lps = new int[pattern.length];

        int i = 1;
        int k = 0;
        while (i < pattern.length) {
            if (pattern[k] == pattern[i]) {
                lps[i] = 1 + lps[i - 1];
                k++;
                i++;
            } else if (k > 0) {
                k = lps[k - 1];
            } else {
                i++;
            }
        }
        return lps;
    }
}

package com.raed.dsa.chapter2.impl;

/**
 * Created by Raed Saeed on 8/18/2021
 **/
public class CipherEncryption {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        String hello = "H";
        String encryptedMessage = cipher.encrypt(hello);
        System.out.println("Encoded message -> " + encryptedMessage);
        System.out.println("Decoded message -> " + cipher.decrypt(encryptedMessage));
    }

    public static class CaesarCipher {
        private final char[] encoders = new char[26];
        private final char[] decoders = new char[26];

        public CaesarCipher(int rotation) {
            for (int i = 0; i < encoders.length; i++) {
                char encoded = (char) ('A' + (i + rotation) % 26);
                encoders[i] = encoded;

                char decoded = (char) ('A' + (i - rotation + 26) % 26);
                decoders[i] = decoded;
            }
        }

        public String encrypt(String message) {
            return transform(message, encoders);
        }

        public String decrypt(String message) {
            return transform(message, decoders);
        }

        private String transform(String text, char[] coders) {
            char[] message = text.toCharArray();
            for (int j = 0; j < message.length; j++) {
                if (Character.isUpperCase(message[j])) {
                    int indexOfDecoded = message[j] - 'A';
                    message[j] = coders[indexOfDecoded];
                }
            }

            return new String(message);
        }
    }
}

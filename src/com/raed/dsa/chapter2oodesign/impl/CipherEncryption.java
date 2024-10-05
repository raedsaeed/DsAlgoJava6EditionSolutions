package com.raed.dsa.chapter2oodesign.impl;

/**
 * Created by Raed Saeed on 8/18/2021
 **/
public class CipherEncryption {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        String hello = "Hi, Raed How are you?";
        String encryptedMessage = cipher.encrypt(hello);
        System.out.println("Encrypted message -> " + encryptedMessage);
        System.out.println("Decrypted message -> " + cipher.decrypt(encryptedMessage));
    }

    public static class CaesarCipher {
        private final int charactersNumber = 26;
        private final char[] encoders = new char[charactersNumber * 2];
        private final char[] decoders = new char[charactersNumber * 2];

        public CaesarCipher(int rotation) {
            for (int i = 0; i < charactersNumber; i++) {
                char encoded = (char) ('A' + (i + rotation) % charactersNumber);
                encoders[i] = encoded;

                char decoded = (char) ('A' + (i - rotation + charactersNumber) % charactersNumber);
                decoders[i] = decoded;
            }

            for (int j = 26; j < encoders.length; j++) {
                char encoded = (char) ('a' + (j + rotation) % charactersNumber);
                encoders[j] = encoded;

                char decoded = (char) ('a' + (j - rotation) % charactersNumber);
                decoders[j] = decoded;
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

                } else if (Character.isLowerCase(message[j])) {
                    int indexOfDecoded = message[j] - 'a';
                    message[j] = coders[indexOfDecoded + charactersNumber];
                }
            }

            return new String(message);
        }
    }
}

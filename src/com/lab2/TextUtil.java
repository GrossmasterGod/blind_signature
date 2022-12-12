package com.lab2;


public class TextUtil {
    public static int findPosition(char inputLetter) {
        return (int) Math.abs(inputLetter - 96);
    }

    public static char getLetterFromPosition(int pos) {
        int position = pos + 96;
        return (char) position;
    }

    public static String hashingMessage(String text, int n) {
        StringBuilder result = new StringBuilder();
        result.append(text.charAt(0));//11
        for (int i = 1; i < text.length(); i++) {
            int textPos = (findPosition(text.charAt(i)));//17
            int tmp = ((findPosition(result.charAt(i - 1))) + textPos) % n;//28
            result.append(getLetterFromPosition(tmp));
            // 11 28
        }
        return result.toString();
    }

    public static String rehashingMessage(String hash, int n) {
        StringBuilder result = new StringBuilder();
        result.append(hash.charAt(0));
        for (int i = 1; i < hash.length(); i++) {
            int hashPos = (findPosition(hash.charAt(i)));
            int hashPrevPos = findPosition(hash.charAt(i - 1));
            int tmp = Math.abs(hashPrevPos - hashPos) % n;
            result.append(getLetterFromPosition(tmp));
        }
        return result.toString();
    }
}

package com.teachmeskills.homework8.task3;

public class TextFormater {

    static boolean isThreeOrFive(String str) {
        return (wordСount(str) >= 3 && wordСount(str) <= 5);
    }

    private static int wordСount(String str) {
        String[] arrayStr = str.split(" ");
        return arrayStr.length;
    }

    static boolean isPalindrome(String str) {
        String[] arrayStr = str.split(" ");
        boolean result = false;
        for (int i = 0, j = 0; i < arrayStr.length; i++) {
            String word = arrayStr[i];
            if (isWordPalindrome(word.toLowerCase())) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isWordPalindrome(String str) {
        if (str.length() == 1) {
            return false;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

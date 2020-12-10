package com.teachmeskills.homework8.task3;

public class Text extends TextFormater {

    public String formatText(String string) {
        String[] strings = string.split("[.!?]");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            if (isThreeOrFive(str.trim()) || isPalindrome(str.trim())) {
                stringBuilder.append(str).append(".");
            }
        }
        return stringBuilder.toString();
    }
}

package com.teachmeskills.homework8;

/**
 * В исходном тексте находятся слова,
 * каждое слово на новой строке.
 * После запуска программы должна создаться строка,
 * которая будет содержать в себе только палиндромы
 */
public class Task2 {

    public static void main(String[] args) {
        String str = "Казак" + "\n" + "собака" + "\n" + "потоп" + "\n" + "Лодка" + "\n" + "летеЛ" + "\n" + "тУт" + "\n" + "дед" + "\n" + "самолет" + "\n" + "ручка" + "\n" + "ищи";
        System.out.println(onlyPalindromes(str));
    }

    public static String onlyPalindromes(String str) {
        String[] arrayStr = str.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayStr.length; i++) {
            if (isPalindrome(arrayStr[i].toLowerCase())) {
                stringBuilder.append(arrayStr[i]).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

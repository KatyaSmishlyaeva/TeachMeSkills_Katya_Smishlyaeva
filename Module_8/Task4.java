package com.teachmeskills.homework8;

/**
 * Написать метод, который на вход принимает строку,
 * состоящую из слов, разделенных запятой,
 * а на выход возвращает строку с этими же словами,
 * но отсортированными по алфавиту.
 * Сортировка должна быть по всему слову (не только по первой букве)
 */
public class Task4 {

    public static void main(String[] args) {
        String str = "Christmas,Day,is,one,of,the,most,favorite,American,holidays,It,Is,celebrated,on,December";
        System.out.println(sorted(str));
    }

    public static String sorted(String str) {
        String[] arrayString = str.split(",");
        for (int i = 0; i < arrayString.length; i++) {
            for (int j = i + 1; j < arrayString.length; j++) {
                if (arrayString[j].compareToIgnoreCase(arrayString[i]) < 0) {
                    String temp = arrayString[i];
                    arrayString[i] = arrayString[j];
                    arrayString[j] = temp;
                }
            }
        }
        return String.join(",", arrayString);
    }
}

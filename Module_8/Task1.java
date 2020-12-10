package com.teachmeskills.homework8;

/**
 * 1) Вырезать подстроку из строки начиная с первого вхождения символа(А)
 * до, последнего вхождения символа(B).
 */
public class Task1 {

    public static void main(String[] args) {
        String str = "HOSPITALITY — AN ATTITUDE OF THE HEART BY DIANA";
        returnSubstring(str);

        String str2 = "At an American home";
        returnSubstring(str2);

        String str3 = "BE READY EARLY";
        returnSubstring(str3);
    }

    public static void returnSubstring(String str) {
        try {
            if (!str.contains("A") || !str.contains("B")) {
                throw new StringIndexOutOfBoundsException("Элемент(элементы) не найден");
            }
            int startIndex = str.indexOf('A');
            int endIndex = str.lastIndexOf('B');
            if (startIndex > endIndex) {
                throw new IndexOutOfBoundsException("Подстрока не найдена");
            } else {
                System.out.println(str.substring(startIndex, endIndex));
            }
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

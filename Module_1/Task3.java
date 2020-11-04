package com.teachmeskills.homework2;

/**
 * Дано целое число. Если оно является положительным,
 * то прибавить к нему 1. Если отрицательным, то вычесть из него 2.
 * Если нулевым, то заменить его на 10. Вывести полученное число.
 */
public class Task3 {

    public static void main(String[] args) {
        int number = 10;

        if (number > 0) {
            System.out.println("Число рано: " + (number + 1));
        } else if (number < 0) {
            System.out.println("Число рано: " + (number - 2));
        } else {
            System.out.println("Число рано: " + 10);
        }
    }
}

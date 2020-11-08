package com.teachmeskills.homework2;

/**
 * Даны 3 целых числа. Найти количество положительных чисел в исходном наборе.
 */
public class Task4 {

    public static void main(String[] args) {
        int a = 100;
        int b = -7;
        int c = 0;
        int count = 0;

        if (a > 0) {
            count++;
        }
        if (b > 0) {
            count++;
        }
        if (c > 0) {
            count++;
        }
        System.out.println("Количество положительных чисел в исходном наборе: " + count);
    }
}

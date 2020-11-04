package com.teachmeskills.homework2;

/**
 * Даны 3 целых числа. Найти количество положительных чисел в исходном наборе.
 */
public class Task4 {

    public static void main(String[] args) {
        int a = 80;
        int b = -17;
        int c = 53;

        if (a > 0 && b > 0 && c > 0) {
            System.out.println("Положительных чисел: " + 3);
        } else if ((a > 0 && b > 0 && c < 0) || (a > 0 && b < 0 && c > 0) || (a < 0 && b > 0 && c > 0)) {
            System.out.println("Положительных чисел: " + 2);
        } else if ((a > 0 && b < 0 && c < 0) || (a < 0 && b < 0 && c > 0) || (a < 0 && b > 0 && c < 0)) {
            System.out.println("Положительных чисел: " + 1);
        } else {
            System.out.println("Положительных чисел нет");
        }
    }
}

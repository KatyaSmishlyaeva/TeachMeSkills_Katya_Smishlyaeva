package com.teachmeskills.homework2;

/**
 * Даны 3 целых числа. Найти количество положительных и отрицательных чисел в исходном наборе.
 */
public class Task5 {

    public static void main(String[] args) {
        int a = 10;
        int b = -17;
        int c = 9;

        if (a > 0 && b > 0 && c > 0) {
            System.out.println("Положительных чисел: " + 3 + ", отрицательных чисел: " + 0);
        } else if ((a > 0 && b > 0 && c < 0) || (a > 0 && b < 0 && c > 0) || (a < 0 && b > 0 && c > 0)) {
            System.out.println("Положительных чисел: " + 2 + ", отрицательных чисел: " + 1);
        } else if ((a > 0 && b < 0 && c < 0) || (a < 0 && b < 0 && c > 0) || (a < 0 && b > 0 && c < 0)) {
            System.out.println("Положительных чисел: " + 1 + ", отрицательных чисел: " + 2);
        } else {
            System.out.println("Положительных чисел: " + 0 + ", отрицательных чисел: " + 3);
        }
    }
}

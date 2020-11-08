package com.teachmeskills.homework2;

/**
 * Даны 3 целых числа. Найти количество положительных и отрицательных чисел в исходном наборе.
 */
public class Task5 {

    public static void main(String[] args) {
        int a = 10;
        int b = -19;
        int c = 0;
        int negativeCount = 0;
        int positiveCount = 0;

        if (a > 0) {
            positiveCount++;
        } else if (a < 0) {
            negativeCount++;
        }

        if (b > 0) {
            positiveCount++;
        } else if (b < 0) {
            negativeCount++;
        }

        if (c > 0) {
            positiveCount++;
        } else if (c < 0) {
            negativeCount++;
        }

        System.out.println("Количество положительных чисел: " + positiveCount + ", отрицательных: " + negativeCount);
    }
}

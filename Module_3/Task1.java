package com.teachmeskills.homework4;

import java.util.Random;

/**
 * Создайте массив из n случайных целых чисел из отрезка [0;10],
 * выведите его на экран в строку. Определить и вывести на экран
 * сообщение о том, является ли массив строго возрастающей последовательностью.
 */
public class Task1 {

    public static void main(String[] args) {
        int n = 3;
        int[] values = getArray(n);
        printArray(values);

        if (isIncreasingSequence(values)) {
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью");
        }
    }

    public static boolean isIncreasingSequence(int[] values) {
        boolean result = true;
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] >= values[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int[] getArray(int n) {
        int[] values = new int[n];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(11);
        }
        return values;
    }

    public static void printArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}

package com.teachmeskills.homework4;

import java.util.Arrays;
import java.util.Random;

/**
 * Найти второй по величине (т.е. следующий по величине за максимальным) элемент в массиве.
 */
public class Task3 {

    public static void main(String[] args) {
        int[] values = getArray();
        int secondMaxValue = getSecondMaxValue(values);

        System.out.println(Arrays.toString(values));
        System.out.println("Второй по величине элемент в массиве: " + secondMaxValue);
    }

    public static int[] getArray() {
        Random random = new Random();
        int[] values = new int[15];
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(200) - 100;
        }
        return values;
    }

    public static int getSecondMaxValue(int[] values) {
        int maxValue = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }

        int maxSecondValue = values[0];
        for (int i = 0; i < values.length; i++) {
            if (maxSecondValue < maxValue && values[i] > maxSecondValue && values[i] != maxValue) {
                maxSecondValue = values[i];
            }
        }
        return maxSecondValue;
    }
}

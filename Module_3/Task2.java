package com.teachmeskills.homework4;

import java.util.Arrays;
import java.util.Random;

/**
 * Создайте массив из 20 случайных целых чисел из отрезка [0;15].
 * Определите какой элемент является в этом массиве максимальным
 * и сообщите индекс его последнего вхождения в массив.
 */
public class Task2 {

    public static void main(String[] args) {
        int[] values = getArray();
        int maxValue = getMaxValue(values);
        int maxIndex = getMaxIndex(values, maxValue);
        System.out.println(Arrays.toString(values));
        System.out.println("Максимальный элемент: " + maxValue + ", индекc его последнего вхождения в массив: " + maxIndex);

    }

    public static int[] getArray() {
        int[] values = new int[20];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(16);
        }
        return values;
    }

    public static int getMaxValue(int[] values) {
        int maxValue = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }

    public static int getMaxIndex(int[] values, int maxValue) {
        int maxIndex = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == maxValue) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

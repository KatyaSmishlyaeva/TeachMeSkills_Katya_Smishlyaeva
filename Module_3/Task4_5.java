package com.teachmeskills.homework4;

import java.util.Scanner;

/**
 * Создаём квадратную матрицу, размер вводим с клавиатуры.
 * Заполняем случайными числами в диапазоне от 0 до 50.
 * И выводим на консоль(в виде матрицы).
 * Транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д
 */
public class Task4_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int n = scanner.nextInt();

        int[][] values = com.teachmeskills.homework4.Task4_1.getArray(n);
        com.teachmeskills.homework4.Task4_1.printArray(values);
        int[][] values2 = transposeArray(values);
        System.out.println("Транспонированная матрица: ");
        com.teachmeskills.homework4.Task4_1.printArray(values2);
    }

    public static int[][] transposeArray(int[][] values) {
        int[][] newValues = new int[values.length][values.length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                newValues[i][j] = values[j][i];
            }
        }
        return newValues;
    }
}


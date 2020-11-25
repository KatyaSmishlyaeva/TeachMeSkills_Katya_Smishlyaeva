package com.teachmeskills.homework4;

import java.util.Random;
import java.util.Scanner;

/**
 * Создаём квадратную матрицу, размер вводим с клавиатуры.
 * Заполняем случайными числами в диапазоне от 0 до 50.
 * И выводим на консоль(в виде матрицы).
 * Посчитать сумму четных элементов стоящих на главной диагонали.
 */
public class Task4_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int n = scanner.nextInt();

        int[][] values = getArray(n);
        printArray(values);

        int sum = sumEvenValues(values);
        System.out.println("Сумма четных элементов стоящих на главной диагонали: " + sum);
    }

    public static int sumEvenValues(int[][] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            int j = i;
            if (values[i][j] % 2 == 0) {
                sum += values[i][j];
            }
        }
        return sum;
    }

    public static int[][] getArray(int n) {
        Random random = new Random();
        int[][] values = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                values[i][j] = random.nextInt(51);
            }
        }
        return values;
    }

    public static void printArray(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                System.out.printf("%d\t", values[i][j]);
            }
            System.out.println();
        }
    }
}

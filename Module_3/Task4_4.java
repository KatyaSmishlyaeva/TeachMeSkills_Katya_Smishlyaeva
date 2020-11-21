package com.teachmeskills.homework4;

import java.util.Scanner;

/**
 * Создаём квадратную матрицу, размер вводим с клавиатуры.
 * Заполняем случайными числами в диапазоне от 0 до 50.
 * И выводим на консоль(в виде матрицы).
 * Посчитать сумму четных элементов стоящих над побочной диагональю (не включительно)
 */
public class Task4_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int n = scanner.nextInt();

        int[][] values = com.teachmeskills.homework4.Task4_1.getArray(n);
        com.teachmeskills.homework4.Task4_1.printArray(values);

        int sumEvenValues = sumEvenValuesUpside(values);
        System.out.println("Сумма четных элементов стоящих над побочной диагональю (не включительно): " + sumEvenValues);
    }

    public static int sumEvenValuesUpside(int[][] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[i][j] % 2 == 0) {
                    sum += values[i][j];
                }
            }
        }
        return sum;
    }
}

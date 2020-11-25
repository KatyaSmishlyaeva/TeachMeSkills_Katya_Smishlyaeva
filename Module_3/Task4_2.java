package com.teachmeskills.homework4;

import java.util.Scanner;

/**
 * Создаём квадратную матрицу, размер вводим с клавиатуры.
 * Заполняем случайными числами в диапазоне от 0 до 50.
 * И выводим на консоль(в виде матрицы).
 * Вывести нечетные элементы находящиеся под главной диагональю(включительно).
 */
public class Task4_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int n = scanner.nextInt();

        int[][] values = com.teachmeskills.homework4.Task4_1.getArray(n);
        com.teachmeskills.homework4.Task4_1.printArray(values);

        System.out.println("Нечетные элементы находящиеся под главной диагональю (включительно): ");
        sumOddValuesUnderDiagonal(values);
    }

    public static void sumOddValuesUnderDiagonal(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (values[i][j] % 2 != 0) {
                    System.out.print(values[i][j] + " ");
                }
            }
        }
    }
}

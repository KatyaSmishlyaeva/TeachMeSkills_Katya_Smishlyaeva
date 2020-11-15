package com.teachmeskills.homework4;

import java.util.Scanner;

/**
 * Создаём квадратную матрицу, размер вводим с клавиатуры.
 * Заполняем случайными числами в диапазоне от 0 до 50.
 * И выводим на консоль(в виде матрицы).
 * Проверить произведение элементов какой диагонали больше.
 */
public class Task4_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int n = scanner.nextInt();

        int[][] values = com.teachmeskills.homework4.Task4_1.getArray(n);
        com.teachmeskills.homework4.Task4_1.printArray(values);

        int mainDiagonal = multiplicationMainDiagonal(values);
        int sideDiagonal = multiplicationSideDiagonal(values);
        largestMultiplicationDiagonal(mainDiagonal, sideDiagonal);
    }

    public static void largestMultiplicationDiagonal(int mainDiagonal, int sideDiagonal) {
        if (mainDiagonal > sideDiagonal) {
            System.out.println("Произведение элементов главной диагонали больше произведения элементов побочной диагонали и равно: " + mainDiagonal);
        } else if (mainDiagonal < sideDiagonal) {
            System.out.println("Произведение элементов побочной диагонали больше произведения элементов главной диагонали и равно: " + sideDiagonal);
        } else {
            System.out.println("Произведение элементов главной диагонали равно произведению элементов побочной диагонали и равно: " + mainDiagonal);
        }
    }

    public static int multiplicationMainDiagonal(int[][] values) {
        int resultMultiplication = 1;
        for (int i = 0; i < values.length; i++) {
            int j = i;
            resultMultiplication *= values[i][j];
        }
        return resultMultiplication;
    }

    public static int multiplicationSideDiagonal(int[][] values) {
        int resultMultiplication = 1;
        for (int i = 0; i < values.length; i++) {
            int j = values.length - 1 - i;
            resultMultiplication *= values[i][j];
        }
        return resultMultiplication;
    }
}

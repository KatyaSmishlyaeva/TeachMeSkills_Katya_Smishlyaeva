package com.teachmeskills.homework3;

import java.util.Scanner;

/**
 * А для самых смелых… Написать метод для перемножения двух матриц.
 * Провести проверку возможности перемножения
 * (число столбцов первой матрицы должно быть равно числу строк второй).
 * Ввод размера и элементов матриц осуществить с консоли.
 * Результирующую матрицу вывести в консоль в читаемом виде
 */
public class Task9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк в первой матрице");
        int row1 = scanner.nextInt();
        System.out.println("Введите количество столбцов в первой матрице");
        int column1 = scanner.nextInt();

        System.out.println("Введите количество строк во второй матрице");
        int row2 = scanner.nextInt();
        System.out.println("Введите количество столбцов во второй матрице");
        int column2 = scanner.nextInt();

        if (column1 == row2) {
            int[][] matrix1 = getMatrix(row1, column1);
            int[][] matrix2 = getMatrix(row2, column2);
            multiplicationMatrix(matrix1, matrix2);
        } else {
            System.out.println("Такие матрицы не могут быть перемножены,так как количество столбцов первой матрицы не равно количеству строк второй матрицы.");
        }
    }

    public static int[][] getMatrix(int row1, int column1) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[row1][column1];
        System.out.println("Ведите значение матрицы");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1[0].length;
        int row2 = matrix2[0].length;
        int column1 = matrix1.length;
   
        int[][] resultMatrix = new int[column1][row2];
        for (int i = 0; i < column1; i++) {
            for (int j = 0; j < row2; j++) {
                for (int k = 0; k < row1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        printMatrix(resultMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}

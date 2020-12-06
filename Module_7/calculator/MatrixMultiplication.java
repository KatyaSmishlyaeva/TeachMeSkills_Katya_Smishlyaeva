package com.teachmeskills.homework7.calculator;

import com.teachmeskills.homework7.calculator.exception.*;

public class MatrixMultiplication extends Calculator implements Calculation {

    @Override
    public void calculations() {
        System.out.println(INPUT_NUMBER + " строк в первой матрице");
        int row1 = getNumber();
        System.out.println(INPUT_NUMBER + " столбцов в первой матрице");
        int column1 = getNumber();
        System.out.println(INPUT_NUMBER + " строк во второй матрице");
        int row2 = getNumber();
        System.out.println(INPUT_NUMBER + " столбцов во второй матрице");
        int column2 = getNumber();
        try {
            if (column1 == row2) {
                int[][] matrix1 = getMatrix(row1, column1);
                int[][] matrix2 = getMatrix(row2, column2);
                multiplicationMatrix(matrix1, matrix2);
                continuing();
            } else {
                throw new MatrixCanNotMultipliedException("Матрицы нельзя перемножить");
            }
        } catch (MatrixCanNotMultipliedException exception) {
            System.out.println(exception.getMessage());
            continuing();
        }
    }

    private void continuing() {
        System.out.println(MENU);
        String str = scanner.nextLine();
        isQorM(str);
        if (str.toLowerCase().equals("c")) {
            calculations();
        }
    }

    private int getNumber() {
        int value;
        String str = scanner.nextLine();
        isQorM(str);
        try {
            value = Integer.parseInt(str);
            if (value < 0)
                throw new NegativeValueException("Число должно быть больше 0");
        } catch (NumberFormatException exception) {
            System.out.println(INVALID_VALUE);
            value = getNumber();
        } catch (NegativeValueException exception) {
            System.out.println(exception.getMessage());
            value = getNumber();
        }
        return value;
    }

    private int[][] getMatrix(int row1, int column1) {
        int[][] matrix = new int[row1][column1];
        System.out.println("Ведите значение матрицы");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                matrix[i][j] = getNumberForMatrix();
            }
        }
        return matrix;
    }

    private int getNumberForMatrix() {
        int value;
        String str = scanner.nextLine();
        isQorM(str);
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException exception) {
            System.out.println(INVALID_VALUE);
            value = getNumber();
        }
        return value;
    }

    private static void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
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

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}

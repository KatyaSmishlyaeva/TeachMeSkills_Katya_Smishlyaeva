package com.teachmeskills.homework7.calculator;

import com.teachmeskills.homework7.calculator.exeptions.*;
import com.teachmeskills.homework7.calculator.operations.*;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void getInput() throws CalculationException {
        System.out.println("Сделайте выбор: арифметические операции - a, умножение матриц - r, выход - q.");
        String input = scanner.nextLine();
        switch (input.toLowerCase()) {
            case "a":
                new ArithmeticOperations().calculations();
                break;
            case "r":
                new MatrixMultiplication().calculationsMatrix();
                break;
            case "q":
                throw new ExitException("Пока...");
            default:
                throw new InvalidInputException(Constants.INVALID_VALUE);
        }
    }

    public void isQorM(String str) throws CalculationException {
        switch (str.toLowerCase()) {
            case "q":
                throw new ExitException("Пока...");
            case "m":
                getInput();
        }
    }

    class ArithmeticOperations {

        public void calculations() throws CalculationException {
            double firstNumber = getNumber();
            double secondNumber = getNumber();
            double result = arithmeticCalculation(firstNumber, secondNumber);
            System.out.println(result);
            while (true) {
                System.out.println(Constants.MENU);
                String str = scanner.nextLine();
                isQorM(str);
                if (str.toLowerCase().equals("c")) {
                    firstNumber = result;
                    secondNumber = getNumber();
                    result = arithmeticCalculation(firstNumber, secondNumber);
                    System.out.println(result);
                }
            }
        }

        private double arithmeticCalculation(double firstNumber, double secondNumber) throws CalculationException {
            double result = 0;
            switch (getOperation()) {
                case "+":
                    result = (Double) new Addition().calculations(firstNumber, secondNumber);
                    break;
                case "-":
                    result = (Double) new Subtraction().calculations(firstNumber, secondNumber);
                    break;
                case "*":
                    result = (Double) new Multiplication().calculations(firstNumber, secondNumber);
                    break;
                case "/":
                    try {
                        if (secondNumber == 0) {
                            throw new ArithmeticException("Нельзя делить на ноль.");
                        } else {
                            result = (Double) new Division().calculations(firstNumber, secondNumber);
                        }
                    } catch (ArithmeticException exception) {
                        System.out.println(exception.getMessage());
                    }
            }
            return result;
        }

        private double getNumber() throws CalculationException {
            System.out.println(Constants.INPUT_NUMBER);
            double value;
            String str = scanner.nextLine();
            isQorM(str);
            try {
                value = Double.parseDouble(str);
            } catch (NumberFormatException exception) {
                System.out.println(Constants.INVALID_VALUE);
                value = getNumber();
            }
            return value;
        }

        private String getOperation() throws CalculationException {
            System.out.println("Введите операцию: +, -, *, /");
            String operation = scanner.nextLine();
            isQorM(operation);
            if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
                System.out.println(Constants.INVALID_VALUE);
                operation = getOperation();
            }
            return operation;
        }
    }

    class MatrixMultiplication {

        public void calculationsMatrix() throws CalculationException {
            System.out.println(Constants.INPUT_NUMBER + " строк в первой матрице");
            int row1 = getNumber();
            System.out.println(Constants.INPUT_NUMBER + " столбцов в первой матрице");
            int column1 = getNumber();
            System.out.println(Constants.INPUT_NUMBER + " строк во второй матрице");
            int row2 = getNumber();
            System.out.println(Constants.INPUT_NUMBER + " столбцов во второй матрице");
            int column2 = getNumber();
            try {
                if (column1 == row2) {
                    int[][] matrix1 = getMatrix(row1, column1);
                    int[][] matrix2 = getMatrix(row2, column2);
                    multiplicationMatrix(matrix1, matrix2);
                    continuation();
                } else {
                    throw new MatrixCanNotMultipliedException("Матрицы нельзя перемножить");
                }
            } catch (MatrixCanNotMultipliedException exception) {
                System.out.println(exception.getMessage());
                continuation();
            }
        }

        private void continuation() throws CalculationException {
            System.out.println(Constants.MENU);
            String str = scanner.nextLine();
            isQorM(str);
            if (str.toLowerCase().equals("c")) {
                calculationsMatrix();
            }
        }

        private int getNumber() throws CalculationException {
            int value;
            String str = scanner.nextLine();
            isQorM(str);
            try {
                value = Integer.parseInt(str);
                if (value < 0)
                    throw new NegativeValueException("Число должно быть больше 0");
            } catch (NumberFormatException exception) {
                System.out.println(Constants.INVALID_VALUE);
                value = getNumber();
            } catch (NegativeValueException exception) {
                System.out.println(exception.getMessage());
                value = getNumber();
            }
            return value;
        }

        private int[][] getMatrix(int row1, int column1) throws CalculationException {
            int[][] matrix = new int[row1][column1];
            System.out.println("Ведите значение матрицы");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column1; j++) {
                    matrix[i][j] = getNumberForMatrix();
                }
            }
            return matrix;
        }

        private int getNumberForMatrix() throws CalculationException {
            int value;
            String str = scanner.nextLine();
            isQorM(str);
            try {
                value = Integer.parseInt(str);
            } catch (NumberFormatException exception) {
                System.out.println(Constants.INVALID_VALUE);
                value = getNumber();
            }
            return value;
        }

        private void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
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

        private void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.printf("%3d", matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}

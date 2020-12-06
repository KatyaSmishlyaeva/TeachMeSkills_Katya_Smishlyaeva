package com.teachmeskills.homework7.calculator;

import com.teachmeskills.homework7.calculator.exception.*;
import java.util.Scanner;

public class Calculator {
    public static final String INVALID_VALUE = "Вы допустили ошибку при вводе. Попробуйте еще раз. ";
    public static final String INPUT_NUMBER = "Введите число";
    public static final String MENU = "Продолжить - c, основное меню - m, выйти - q";
    public static Scanner scanner = new Scanner(System.in);

    public Calculator() {
    }

    public void start() {
        System.out.println("Сделайте выбор: арифметические операции - a, умножение матриц - r, выход - q.");
        String input = scanner.nextLine();
        switch (input.toLowerCase()) {
            case "a":
                new ArithmeticOperations().calculations();
                break;
            case "r":
                new MatrixMultiplication().calculations();
                break;
            case "q":
                goodbye();
                break;
            default:
                try {
                    throw new InvalidInputException(INVALID_VALUE);
                } catch (InvalidInputException exception) {
                    System.out.println(exception.getMessage());
                    start();
                }
        }
    }

    void isQorM(String str) {
        if (str.toLowerCase().equals("q")) {
            goodbye();
        } else if (str.toLowerCase().equals("m")) {
            start();
        }
    }

    void goodbye() {
        try {
            throw new ExitException("Пока...");
        } catch (ExitException exception) {
            System.out.println(exception.getMessage());
        }
        System.exit(0);
    }
}

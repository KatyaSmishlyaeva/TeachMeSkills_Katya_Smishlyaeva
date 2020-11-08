package com.teachmeskills.homework3;

import java.util.Scanner;

/**
 * Составьте программу, вычисляющую A*B, не пользуясь операцией умножения.
 */
public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, которое хотите умножить: ");
        int value = scanner.nextInt();
        System.out.println("Введите число, на которое хотите умножить: ");
        int value2 = scanner.nextInt();
        System.out.println(value + " * " + value2 + " = " + multiplication(value, value2));
    }

    public static int multiplication(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }
}

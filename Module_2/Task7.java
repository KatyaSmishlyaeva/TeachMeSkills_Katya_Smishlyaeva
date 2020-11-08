package com.teachmeskills.homework3;

/**
 * Напишите программу, определяющую сумму всех нечетных чисел от 1 до 99
 */
public class Task7 {

    public static void main(String[] args) {
        System.out.println("Сумма всех нечетных чисел от 1 до 99: " + sum());
    }

    public static int sum() {
        int sum = 0;
        for (int i = 1; i <= 99; i += 2) {
            sum += i;
        }
        return sum;
    }
}

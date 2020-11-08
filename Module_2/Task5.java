package com.teachmeskills.homework3;

import java.util.Scanner;

/**
 * Напишите программу печати таблицы перевода расстояний
 * из дюймов в сантиметры для значений длин от 1 до 20 дюймов.
 * 1 дюйм = 2,54 см
 */
public class Task5 {

    public static void main(String[] args) {
        int value = getValue();
        System.out.println(value + " " + printInch(value) + " = " + valueInСentimeter(value) + " см");
    }

    public static int getValue() {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("Введите расстояние в дюймах от 1 до 20!");
            value = scanner.nextInt();
        } while (value < 1 || value > 20);
        return value;
    }

    public static double valueInСentimeter(int value) {
        final double CONSTANCE = 2.54;
        return value * CONSTANCE;
    }

    public static String printInch(int value) {
        String inch;
        if (value == 1) {
            inch = "дюйм";
        } else if (value >= 2 && value <= 4) {
            inch = "дюйма";
        } else {
            inch = "дюймов";
        }
        return inch;
    }
}

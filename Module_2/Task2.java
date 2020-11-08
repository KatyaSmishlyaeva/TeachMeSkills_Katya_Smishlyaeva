package com.teachmeskills.homework3;

/**
 * Одноклеточная амеба каждые 3 часа делится на 2 клетки.
 * Определить, сколько амеб будет через 3, 6, 9, 12,..., 24 часа.
 */
public class Task2 {

    public static void main(String[] args) {
        amebNumber();
    }

    public static void amebNumber() {
        int countAmeb = 1;
        for (int hours = 3; hours <= 24; hours += 3) {
            countAmeb *= 2;
            System.out.println("Через " + hours + " " + printHours(hours) + " будет: " + countAmeb + " " + printCountAmeb(countAmeb));
        }
    }

    public static String printCountAmeb(int countAmeb) {
        String ameb = "";
        if (countAmeb == 1) {
            ameb = "амеба";
        } else if (countAmeb == 8 || countAmeb == 16 || countAmeb == 128 || countAmeb == 256) {
            ameb = "амеб";
        } else {
            ameb = "амебы";
        }
        return ameb;
    }

    public static String printHours(int hours) {
        String hour = "";
        if (hours == 3 || hours == 24) {
            hour = "часа";
        } else if (hours == 21) {
            hour = "час";
        } else {
            hour = "часов";
        }
        return hour;
    }
}

package com.teachmeskills.homework3;

/**
 * Начав тренировки, спортсмен в первый день пробежал 10 км.
 * Каждый день он увеличивал дневную норму на 10% нормы предыдущего дня.
 * Какой суммарный путь пробежит спортсмен за 7 дней?
 */
public class Task1 {

    public static void main(String[] args) {
        double distance = 10.0;
        int days = 7;
        System.out.println("Спортсмен пробежит за 7 дней: " + resultDistance(distance, days) + " км");
    }

    public static double resultDistance(double distance, int days) {
        double resultDistance = distance;
        for (int i = 1; i < days; i++) {
            distance *= 1.1;
            resultDistance += distance;
        }
        return resultDistance;
    }
}

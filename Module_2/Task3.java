package com.teachmeskills.homework3;

/**
 * Вычислить:  1+2+4+8+…+256
 */
public class Task3 {

    public static void main(String[] args) {
        System.out.println("Сумма 1+2+4+8+…+256 равна: " + sum());
    }

    public static int sum() {
        int sum = 0;
        for (int i = 0; i <= 8; i++) {
            sum += Math.pow(2, i);
        }
        return sum;
    }
}

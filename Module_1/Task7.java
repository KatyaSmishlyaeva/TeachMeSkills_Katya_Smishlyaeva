package com.teachmeskills.homework2;

/**
 * (Со звездочкой) В переменную записываете количество программистов.
 * В зависимости от количества программистов необходимо вывести правильно окончание.
 * Например:
 * • 2 программиста
 * • 1 программист
 * • 10 программистов
 * • и т.д.
 */
public class Task7 {

    public static void main(String[] args) {
        int countProgrammer = 101;

        if (countProgrammer % 10 == 1 && countProgrammer % 100 != 11) {
            System.out.println(countProgrammer + " программист");
        } else if ((countProgrammer % 10 == 2 || countProgrammer % 10 == 3 || countProgrammer % 10 == 4) &&
                countProgrammer % 100 != 12 && countProgrammer % 100 != 13 && countProgrammer % 100 != 14) {
            System.out.println(countProgrammer + " программиста");
        } else {
            System.out.println(countProgrammer + " программистов");
        }
    }
}

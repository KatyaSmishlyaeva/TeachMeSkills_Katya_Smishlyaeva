package com.teachmeskills.homework2;

/**
 * Даны 2 числа. Вывести большее из них.
 */
public class Task6 {

    public static void main(String[] args) {
        int firstNumber = 345;
        int secondNumber = 8945;

        if (firstNumber > secondNumber) {
            System.out.println("Максимальное число: " + firstNumber);
        } else if (firstNumber < secondNumber){
            System.out.println("Максимальное число: " + secondNumber);
        } else {
            System.out.println("Оба числа равны: " + firstNumber);
        }
    }
}

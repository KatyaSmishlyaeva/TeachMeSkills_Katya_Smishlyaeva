package com.teachmeskills.homework3;

/**
 * И ещё можете попрактиковаться и нарисовать 2 треугольника
 */
public class Task8 {

    public static void main(String[] args) {
        String s1 = "*";
        String s2 = " ";
        print1(s1, s2);
        print2(s1, s2);
    }

    public static void print1(String s, String s2) {
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (j < 4 - i) {
                    System.out.print(s2 + " ");
                } else {
                    System.out.print(s + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print2(String s, String s2) {
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j <= 4; j++) {
                if (j < 4 - i) {
                    System.out.print(s2 + " ");
                } else {
                    System.out.print(s + " ");
                }
            }
            System.out.println();
        }
    }
}

package com.teachmeskills.homework8;

/**
 * Создать валидатор даты для следующих форматов, используя regex.
 * “dd/mm/yyyy”
 * “mm/dd/yyyy”
 * “dd/mm/yy hh:mm:ss AM/PM”
 */
public class Task5 {
    static String dd = "(3[01]|[12][0-9]|0[1-9])";
    static String mm = "(1[0-2]|0[1-9])";
    static String year = "((19|20)\\d\\d)";
    static String yr = "([0-9]{2})";
    static String hhmmss = "(0[1-9]|1[0-2])[:]([0-5]\\d)[:]([0-5]\\d)";
    static String amPm = "[AP]M";

    public static void main(String[] args) {
        isValidDdMmYyyy("31/10/1987");
        isValidMmDdYyyy("12/19/2000");
        isValidDdMmYyHhMmSsAmPm("25/04/20 10:23:08 AM");
    }

    public static void isValidDdMmYyyy(String input) {
        String date = String.join("/", dd, mm, year);
        if (input.matches(date)) {
            System.out.println(input + ": valid");
        } else {
            System.out.println(input + ": not valid");
        }
    }

    public static void isValidMmDdYyyy(String input) {
        String date = String.join("/", mm, dd, year);
        if (input.matches(date)) {
            System.out.println(input + ": valid");
        } else {
            System.out.println(input + ": not valid");
        }
    }

    public static void isValidDdMmYyHhMmSsAmPm(String input) {
        String date = String.join("/", dd, mm, yr)
                .concat(" ")
                .concat(hhmmss)
                .concat(" ")
                .concat(amPm);
        if (input.matches(date)) {
            System.out.println(input + ": valid");
        } else {
            System.out.println(input + ": not valid");
        }
    }
}

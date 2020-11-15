package com.teachmeskills.homework4;

import java.util.Scanner;

/**
 * Разработать консольную игру крестики-нолики.
 * В игре участвуют 2 игрока. Они по очереди вводят
 * координаты клетки в которую хотят сделать ход.
 * После каждого хода, в консоли отрисовывается
 * игровое поле с текущим состоянием.
 * Игра продолжается до победы одного из игроков или ничьи.
 * Добавить проверку на правильность ввода.
 */
public class Task5 {

    public static void main(String[] args) {
        String[][] playingTable = {{" . ", " . ", " . "},
                                   {" . ", " . ", " . "},
                                   {" . ", " . ", " . "}};
        ticTacToe(playingTable);
    }

    public static void ticTacToe(String[][] playingTable) {
        String firstUser = "Первый игрок";
        String secondUser = "Второй игрок";
        printPlayingTable(playingTable);
        while (true) {
            playerTurn(playingTable, firstUser);
            printPlayingTable(playingTable);
            if (isWinningTable(playingTable, " X ")) {
                System.out.println(firstUser + ", поздарвляем! Вы победили!");
                break;
            }
            if (isFullTable(playingTable)) {
                System.out.println("Ничья!");
                break;
            }
            playerTurn(playingTable, secondUser);
            printPlayingTable(playingTable);
            if (isWinningTable(playingTable, " 0 ")) {
                System.out.println(secondUser + ", поздарвляем! Вы победили!");
                break;
            }
            if (isFullTable(playingTable)) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Конец игры!");
    }

    public static void playerTurn(String[][] playingTable, String user) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        int current = 0;
        do {
            if (current == 0) {
                System.out.println(user + ", введите координаты x и y, значения от 0 до 2: ");
            } else {
                System.out.println(user + ", ячейка занята или указаны ошибочные координаты. Введите координаты x и y, значения от 0 до 2:");
            }
            current++;
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while (!isCellFree(playingTable, x, y));

        if (user == "Первый игрок") {
            playingTable[x][y] = " X ";
        } else if (user == "Второй игрок") {
            playingTable[x][y] = " 0 ";
        }
    }

    public static void printPlayingTable(String[][] playingTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(playingTable[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isCellFree(String[][] playingTable, int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return playingTable[x][y] == " . ";
    }

    public static boolean isWinningTable(String[][] playingTable, String value) {
        for (int i = 0; i < 3; i++)
            if ((playingTable[i][0] == value && playingTable[i][1] == value && playingTable[i][2] == value) ||
                    (playingTable[0][i] == value && playingTable[1][i] == value && playingTable[2][i] == value) ||
                    (playingTable[0][0] == value && playingTable[1][1] == value && playingTable[2][2] == value) ||
                    (playingTable[2][0] == value && playingTable[1][1] == value && playingTable[0][2] == value))
                return true;
        return false;
    }

    public static boolean isFullTable(String[][] playingTable) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (playingTable[i][j] == " . ") {
                    return false;
                }
        return true;
    }
}

package com.teachmeskills.homework9.task2;

/**
 * Создать класс, который будет уметь:
 * - Записывать текст в файл с консоли
 * - Записывать текст в файл, передаваемы в виде String
 * - Производить автозамену одного слова на другое в текстовом файле.
 * Слова  (Т.е. метод принимает слово, которое надо заменить,
 * слово, на которое надо заменить и путь к файлу.)
 * «Например, заменить в файле все слова Java на JS»
 */
public class FileConsoleRunner {

    public static void main(String[] args) {
        FileConsole.writingTextToFile("resources/test1.txt", true);
        FileConsole.writingStringText("resources/test4.txt", "Hello World!!!", true);
        FileConsole.changeWord("World", "Java", "resources/test4_copy.txt");
    }
}

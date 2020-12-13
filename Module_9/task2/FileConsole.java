package com.teachmeskills.homework9.task2;

import java.io.*;

public class FileConsole {

    public static void writingTextToFile(String filePath, boolean append) {
        try {
            try (InputStreamReader ir = new InputStreamReader(System.in);
                 FileOutputStream fs = new FileOutputStream(filePath, append)) {
                System.out.println("Input text. 'q' to quit");
                char a;
                do {
                    a = (char) ir.read();
                    if (a == 'q') {
                        return;
                    }
                    fs.write(a);
                }
                while (true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writingStringText(String filePath, String text, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, append))) {
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeWord(String word, String newWord, String filePath) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] bytes = inputStream.readAllBytes();
            String stringValue = new String(bytes).replace(word, newWord);
            writingStringText(filePath, stringValue, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

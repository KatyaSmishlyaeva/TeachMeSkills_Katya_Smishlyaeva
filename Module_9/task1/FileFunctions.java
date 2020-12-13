package com.teachmeskills.homework9.task1;

import java.io.*;

/**
 * 1)	Создать класс, который будет уметь:
 * - создавать папки (если папка существует – не пересоздавать)
 * - создавать файлы (- //-)
 * - искать, существует ли файл в конкретной папке. (поиск должен быть по все структуре папок, начиная с исходной)
 * - делать копию любого файла в той же папке, добавляя к имени файла “_copy” (не к расширению файла, а к имени)
 * -удалять файлы
 * - удалять папки
 */
public class FileFunctions {

    public static void createDirs(String dirsPath) {
        File file = new File(dirsPath);
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("Папка " + file.getName() + " создана");
        } else {
            System.out.println("Папка " + file.getName() + " уже существует");
        }
    }

    public static void createFiles(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Файл " + file.getName() + " создан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл " + file.getName() + " уже существует");
        }
    }

    public static void findFile(String nameFile, String dirName) {
        File file = new File(dirName);
        File[] list = file.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile()) {
                if (nameFile.equalsIgnoreCase(list[i].getName())) {
                    System.out.println("Файл " + list[i].getName() + " найден в " + list[i].getParent() + ". Абсолютный путь " + list[i].getAbsolutePath());
                }
            } else if (list[i].isDirectory()) {
                findFile(nameFile, list[i].getPath());
            }
        }
    }

    public static void doCopy(String filePath) throws IOException {
        File file = new File(filePath);
        String[] arrayName = file.getName().split("[.]");
        String nameCopyFile = String.join(".", (arrayName[0] + "_copy"), arrayName[1]);
        String newCopyFilePath = filePath.replace(file.getName(), nameCopyFile);
        File copyFile = new File(newCopyFilePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        if(copyFile.exists()){
            System.out.println("Файл " + copyFile.getName() + " уже существует");
            return;
        }
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             FileOutputStream fileOutputStream = new FileOutputStream(newCopyFilePath)) {
            int a;
            while ((a = fileInputStream.read()) != -1) {
                fileOutputStream.write(a);
            }
            System.out.println("Файл " + nameCopyFile + " создан.");
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            System.out.println("Это не файл, для удаления " + file.getName() + " вызовите метод deleteDirks");
        }
        if (!file.exists()) {
            System.out.println("Файл " + file.getName() + " не существует");
        } else if (file.delete()) {
            System.out.println("Файл " + file.getName() + " удален");
        }
    }

    public static void deleteDirks(String dirPath) {
        File file = new File(dirPath);
        if (file.isFile()) {
            System.out.println("Это не папка, для удаления " + file.getName() + " вызовите метод deleteFile");
        }
        if (!file.exists()) {
            System.out.println("Папка " + file.getName() + " не существует");
        } else if (file.delete()) {
            System.out.println("Папка " + file.getName() + " удалена");
        }
    }
}

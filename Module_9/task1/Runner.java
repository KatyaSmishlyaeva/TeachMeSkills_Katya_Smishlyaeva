package com.teachmeskills.homework9.task1;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        FileFunctions.createDirs("resources/dirs/dir/test3");
        FileFunctions.createFiles("resources/dirs/dir/test3.txt");
        FileFunctions.findFile("test4_copy.txt", "resources");
        FileFunctions.doCopy("resources/test3.txt");
        FileFunctions.deleteFile("resources/test3.txt");
        FileFunctions.deleteDirks("resources/dirs/dir/test5");
    }
}

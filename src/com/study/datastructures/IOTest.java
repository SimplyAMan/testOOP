package com.study.datastructures;

import java.io.File;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) throws IOException {
        File file = new File("test.log");

        System.out.println(file.exists());
        file.createNewFile();
        System.out.println(file.exists());

        System.out.println(file.getAbsolutePath());

        File dir = new File("C:\\Windows");

        for (File path : dir.listFiles()) {
            String type = path.isFile() ? "FILE: " : "DIR:  ";
            System.out.println(type + path.getAbsolutePath());
        }
    }
}
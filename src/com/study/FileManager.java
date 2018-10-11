package com.study;

import java.io.File;
import java.util.Arrays;

public class FileManager {
    private static int dirsCount;

    public static void main(String[] args) {
        System.out.println(countFiles("C:\\Windows"));
    }

    public static int countFiles(String path) {
        int filesCount = 0;
        File newFile = new File(path);
        File[] files = newFile.listFiles();
        if (files != null) {
            for (File root : files) {
                if (root.isDirectory()) {
                    filesCount += countFiles(root.getAbsolutePath());
                } else {
                    filesCount++;
                }
            }
        }
        return filesCount;
    }

    public static int countDirs(String path) {
        File newDir = new File(path);
        for (File root : newDir.listFiles()) {
            if (root.isDirectory()) {
                countDirs(root.getAbsolutePath());
                dirsCount++;
            }
        }
        return dirsCount;
    }

}
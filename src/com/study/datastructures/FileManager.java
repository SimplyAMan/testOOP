package com.study.datastructures;

import java.io.File;

// public static int countFiles(String path) - принимает путь к папке, возвращает количество файлов в папке и всех подпапках по пути
// public static int countDirs(String path) - принимает путь к папке, возвращает количество папок в папке и всех подпапках по пути
public class FileManager {
    public static int countFiles(String path){
        int count = 0;
        File[] files =  new File(path).listFiles();
        int count2 = files.length;
        System.out.println(count2);
        for (File file: files) {
            System.out.println(file.getAbsolutePath());
            if(!file.isDirectory()) {
                count++;
            }
        }
        return count;
    }

    public static int countDirs(String path){
        File dir = new File(path);
        int count = 0;
        for (File file: dir.listFiles()) {
            if(file.isDirectory()) {
                count++;
            }
        }
        return count;
    }
}
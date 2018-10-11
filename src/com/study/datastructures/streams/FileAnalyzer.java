package com.study.datastructures.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 1:
 Написать программу FileAnalyzer, которая в консоли принимает 2 параметра:
 1) путь к файлу
 2) слово
 Usage:
 java FileAnalyzer C:/test/story.txt duck

 Выводит:
 1) Кол-во вхождений искомого слова в файле
 2) Все предложения содержащие искомое слово(предложение заканчивается символами ".", "?", "!"), каждое преждложение с новой строки.

 2:
 public static void copy(String from, String to) - метод по копированию папок и файлов. Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
 */
public class FileAnalyzer {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String word = args[1];

        String[] lines = divideInSentances(readFromFile(path));

        List<String> list = new ArrayList<>();
        list = getSentencesWithWord(lines, word);

//        List<String> resultList = new ArrayList<>();
/*        int count = 0;
        for (String line : lines) {
            if(line.indexOf(word) != -1) {
                resultList.add(line);
                int offset = 0;
                while ((offset = line.indexOf(word, offset)) != -1 ) {
                    offset++;
                    count++;
                }
            }
        }*/
//        System.out.println(count);

        for (String line : list) {
            System.out.print(line);
        }
    }

    static List<String> getSentencesWithWord(String[] lines, String word) {
        List<String> resultList = new ArrayList<>();
        //int count = 0;
        for (String line : lines) {
            if(line.indexOf(word) != -1) {
/*                resultList.add(line);
                int offset = 0;
                while ((offset = line.indexOf(word, offset)) != -1 ) {
                    offset++;
                }*/
            }
        }
        return resultList;
    }


    static String[] divideInSentances(String contents) {
        return contents.split("\\.|\\?|!",0);
    }

    private static String readFromFile(String path) throws IOException {
        StringBuilder result = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(path)) {
            int cout = 0;
            byte[] bytes = new byte[1024];
            while ((cout = inputStream.read(bytes)) != -1) {
                result.append(new String(bytes,0,cout-1));
            }
        }
        return result.toString();
    }
}


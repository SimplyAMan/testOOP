package com.study;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class IOTest {
    public static void main(String[] args) throws IOException {
        String content = readLines("test.log");
        System.out.println(content);
    }

    private static String readLines(String from) throws IOException {
        try (InputStream inputStream = new FileInputStream(from);) {

            StringBuilder content = new StringBuilder();
            byte[] buffer = new byte[1024];
            int count;
            while ((count = inputStream.read(buffer)) != -1) {
                content.append(new String(buffer, 0, count));
            }

            return content.toString();
        }

    }

    static void copy(String from, String to) throws IOException {
        InputStream inputStream = new FileInputStream(from);
        OutputStream outputStream = new FileOutputStream(to);

        try {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, count);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }

    }

    static void fileCopy() throws IOException {
        InputStream inputStream = new FileInputStream("C:\\labs\\test.jpg");
        OutputStream outputStream = new FileOutputStream("C:\\labs\\test_copy.jpg");

        int value;
        while ((value = inputStream.read()) != -1) {
            outputStream.write(value);
        }
    }

    // inputStreamExample
    static void inputStreamExample() throws IOException {
        InputStream inputStream = new FileInputStream("test.log");

        int value = inputStream.read();
        System.out.println(value); // 72

        byte[] buffer = new byte[3];
        int count = inputStream.read(buffer);

        System.out.println(count); // 3
        // [101, 108, 108]
        System.out.println(Arrays.toString(buffer));

        count = inputStream.read(buffer);

        System.out.println(count); // 1
        // [111, 108, 108]
        System.out.println(Arrays.toString(buffer));
        System.out.println(inputStream.read(buffer)); // -1
    }

// test.log
// [72, 101, 108, 108, 111]
// Hello

}

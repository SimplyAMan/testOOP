package com.study.datastructures;

import org.junit.*;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by dsk2 on 10/10/2018.
 */
public class FileManagerTest {
    private String path = "./temp";
    File file = new File(path);

    @Before
    public void before() {
        file.mkdir();
    }

    @After
    public void finish() {
//        file.delete();
    }
/*
    @org.junit.Test
    public void testTempDirExists() throws Exception {
        assertEquals(true, file.exists());
    }

    void emptyDir() {
        System.out.println("emptyDir");
        for (File curFile: file.listFiles()) {
            System.out.println(curFile.getAbsolutePath());
            curFile.delete();
        }
    }

    @Test
    public void testCountFilesInEmptyDir() {
//        emptyDir();
        File test = new File(path + "/firstFile.txt");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getAbsolutePath());
        }

        assertEquals(1,FileManager.countFiles(path));
    }

    @org.junit.Test
    public void testCountDirectories() throws Exception {
        for (int i = 0; i < 10; i++) {
            String newPath = path + "/dir" + i;
            new File(newPath).mkdir();
            new File(newPath + "/abc.txt" );
        }
        assertEquals(10, FileManager.countDirs(path));
    }
    @org.junit.Test
    public void testCountDirectoriesInEmptyDir() throws Exception {
        emptyDir();
        assertEquals(0, FileManager.countDirs(path));
    }
*/
}
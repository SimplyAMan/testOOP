package com.study.datastructures.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dsk2 on 10/11/2018.
 */
public class FileAnalyzerTest {
//    FileAnalyzer fileAnalyzer = new FileAnalyzer();

    @Test
    public void testDivideInSentances() throws Exception {
        String[] result = {"ab cj oo"," lll lo, jj"};
        assertArrayEquals (result, FileAnalyzer.divideInSentances("ab cj oo. lll lo, jj?"));
    }
    @Test
    public void testDivideEmptySentances() throws Exception {
        assertArrayEquals (new String[]{""}, FileAnalyzer.divideInSentances(""));
    }
    @Test
    public void testGetSentencesWithWord() {
        String[] testString = {"ab cj oo"," lll lo, jj"};
        List<String> result = FileAnalyzer.getSentencesWithWord(testString,"oo");
        System.out.println(result);
        List<String> expected = new ArrayList<>();
        expected.add("ab cj oo");
        assertEquals(expected, result);
    }

}
package com.junitStudies.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS","Azure","DevOps");

    @Test
    void test() {
        boolean test = todos.contains("AWS");
        boolean test2 = todos.contains("GCP");
        //assertEquals(true,test);
        assertTrue(test);
        assertFalse(test2);
        assertArrayEquals(new int[] {1,2}, new int[] {1,2});
        assertEquals(3,todos.size());
    }
}
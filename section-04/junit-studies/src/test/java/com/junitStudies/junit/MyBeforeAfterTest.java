package com.junitStudies.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

public class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

}

package com.charuniverse.g_informasi_test;

import org.junit.jupiter.api.*;

@DisplayName("Information Test")
public class InformationTest {
    @Test
    @DisplayName("This is test 1")
    @Tags({
            @Tag("Test1"),
            @Tag("Test2"),
    })
    void test1(TestInfo info) {
        System.out.println(info);
    }
}
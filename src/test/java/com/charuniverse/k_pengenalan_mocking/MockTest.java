package com.charuniverse.k_pengenalan_mocking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {
    @Test
    void testMock() {
        String greet = "Hello";
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn(greet);
        Assertions.assertEquals(greet, list.get(0));
        Mockito.verify(list, Mockito.timeout(1)).get(0);
    }
}
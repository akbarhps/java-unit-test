package com.charuniverse.a_membuat_test;

import com.charuniverse.b_display_name_generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.*;

//@DisplayName("Test Calculator")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {
    public static final Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll() {
        System.out.println("Run Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Run After All");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Run Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run After Each");
    }

    @Test
//    @DisplayName("Test calculator.add(a, b) success")
    public void testAddSuccess() {
        int result = calculator.add(5, 15);
        assertEquals(20, result);
    }

    @Test
//    @DisplayName("Test calculator.divide(a, b) success")
    public void testDivideSuccess() {
        int result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
//    @DisplayName("Test calculator.divide(a, b) throw IllegalArgumentException")
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(100, 0));
    }

    @Test
    @Disabled
    public void testNotImplemented() {
        // not yet implemented
    }

    @Test
    public void testAborted() {
        String profile = System.getenv("PROFILE");
        if(profile == null || !profile.equals("DEV")) {
            throw new TestAbortedException("Not in dev env");
        }
    }

    @Test
    public void testAssumptions() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
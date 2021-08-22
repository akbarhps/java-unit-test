package com.charuniverse.c_condition_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionTest {
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testEnabledOnWindows() {
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows() {
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnabledOnJava8() {
    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisabledOnJava8() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testEnabledOnJava11To15() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testDisabledOnJava11To15() {
    }

    @Test
    @EnabledIfSystemProperties(
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    )
    void testEnabledOnJavaOracle() {
    }

    @Test
    @DisabledIfSystemProperties(
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    )
    void testDisabledOnJavaOracle() {
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledOnDev() {
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledOnDev() {
    }
}
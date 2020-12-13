package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class IsPositiveTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Verify if {0} value is positive")
    @MethodSource("valuesForIsPositiveTrue")
    public void isPositiveTrue(long a) {
        boolean isPositive = calculator.isPositive(a);
        Assertions.assertTrue(isPositive, "Invalid data for isPositive operation");
    }

    @ParameterizedTest(name = " #{index} Verify if {0} value is positive")
    @MethodSource("valuesForIsPositiveFalse")
    public void isPositiveFalse(long a) {
        boolean isPositive = calculator.isPositive(a);
        Assertions.assertFalse(isPositive, "Invalid data for isPositive operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForIsPositiveTrue() {
        return Arrays.asList(new Object[][]{
                {15623616L}
        });
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForIsPositiveFalse() {
        return Arrays.asList(new Object[][]{
                {-25151L},
                {0L}
        });
    }
}

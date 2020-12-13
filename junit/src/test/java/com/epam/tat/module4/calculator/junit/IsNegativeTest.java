package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class IsNegativeTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Verify if {0} value is negative")
    @MethodSource("valuesForIsNegativeTrue")
    public void isNegativeTrue(long a) {
        boolean isNegative = calculator.isNegative(a);
        Assertions.assertTrue(isNegative, "Invalid data for isNegative operation");
    }

    @ParameterizedTest(name = " #{index} Verify if {0} value is negative")
    @MethodSource("valuesForIsNegativeFalse")
    public void isNegativeFalse(long a) {
        boolean isNegative = calculator.isNegative(a);
        Assertions.assertFalse(isNegative, "Invalid data for isNegative operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForIsNegativeTrue() {
        return Arrays.asList(new Object[][]{
                {-25151L}
        });
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForIsNegativeFalse() {
        return Arrays.asList(new Object[][]{
                {15623616L},
                {0L}
        });
    }
}

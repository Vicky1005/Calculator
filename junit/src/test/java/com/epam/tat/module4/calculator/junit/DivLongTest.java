package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class DivLongTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Div long operation {0}/{1}")
    @MethodSource("valuesForDivLongTest")
    public void divLong(long a, long b, long expectedResult) {
        long result = calculator.div(a, b);
        Assertions.assertEquals(result, expectedResult, "Invalid result of div operation");
    }

    @ParameterizedTest(name = " #{index} Div long operation by zero {0}/{1}")
    @MethodSource("valuesForDivLongByZeroTest")
    public void divLongByZero(long a, long b) {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.div(a, b));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForDivLongTest() {
        return Arrays.asList(new Object[][]{
                {15245650L, 65565L, 232L},
                {-105615L, -152L, 694L}
        });
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForDivLongByZeroTest() {
        return Arrays.asList(new Object[][]{
                {151516L, 0L},
                {-105615L, 0L},
                {0L, 0L}
        });
    }
}


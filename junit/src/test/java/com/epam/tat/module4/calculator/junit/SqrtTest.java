package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class SqrtTest extends BaseTest {
    @Tag("sqrt")
    @ParameterizedTest(name = " #{index} Sqrt operation of {0}")
    @MethodSource("valuesForSqrtTest")
    public void sqrtTest(double a, double expectedResult) {
        double result = calculator.sqrt(a);
        Assertions.assertEquals(result, expectedResult, 0.01, "Invalid result of sqrt operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForSqrtTest() {
        return Arrays.asList(new Object[][]{
                {9.8, 3.13},
                {-10.85, 3.29},
                {0.0, 0.0},
        });
    }
}

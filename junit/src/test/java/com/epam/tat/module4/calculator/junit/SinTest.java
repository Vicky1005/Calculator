package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class SinTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Sin operation of {0}")
    @MethodSource("valuesForSinTest")
    public void sinTest(double a, double expectedResult) {
        double result = calculator.sin(a);
        Assertions.assertEquals(result, expectedResult, 0.001, "Invalid result of sin operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForSinTest() {
        return Arrays.asList(new Object[][]{
                {9.8, -0.366},
                {-10.85, 0.989},
                {0.0, 0.0},
                {Math.PI, 1.2246467991473532E-16}
        });
    }
}

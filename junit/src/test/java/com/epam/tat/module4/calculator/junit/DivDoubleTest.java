package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class DivDoubleTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Div double operation by zero {0}/{1}")
    @MethodSource("valuesForDivDoubleByZeroTest")
    public void divDoubleByZero(double a, double b, double expectedResult) {
        double result = calculator.div(a, b);
        Assertions.assertEquals(result, expectedResult, "Invalid result of div operation");
    }

    @ParameterizedTest(name = " #{index} Div double operation {0}/{1}")
    @MethodSource("valuesForDivDoubleTest")
    public void divDouble(double a, double b, double expectedResult) {
        double result = calculator.div(a, b);
        Assertions.assertEquals(result, expectedResult, 0.001, "Invalid result of div operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForDivDoubleTest() {
        return Arrays.asList(new Object[][]{
                {15047585.35, 6858.01, 2194.162},
                {-1156.10, -7.80, 148.217}
        });
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForDivDoubleByZeroTest() {
        return Arrays.asList(new Object[][]{
                {-520.63, 0, Double.NEGATIVE_INFINITY},
                {1156.10, 0, Double.POSITIVE_INFINITY}
        });
    }
}

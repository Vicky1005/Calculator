package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class SumDoubleTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Sum double operation {0}+{1}")
    @MethodSource("valuesForSumDouble")
    public void sumDouble(double a, double b, double expectedResult) {
        double result = calculator.sum(a, b);
        Assertions.assertEquals(result, expectedResult, "Invalid result of sum operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForSumDouble() {
        return Arrays.asList(new Object[][]{
                {1082.587, 237.66, 1320.247,},
                {-7410.071, -15255.020, -22665.091},
                {0.00, 0.000, 0.0}
        });
    }
}

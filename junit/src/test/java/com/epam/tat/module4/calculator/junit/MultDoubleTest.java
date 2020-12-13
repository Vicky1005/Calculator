package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class MultDoubleTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Mult double operation {0}*{1}")
    @MethodSource("valuesForMultDouble")
    public void multDouble(double a, double b, double expectedResult) {
        double result = calculator.mult(a, b);
        Assertions.assertEquals(result, expectedResult, 0.001, "Invalid result of mult operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForMultDouble() {
        return Arrays.asList(new Object[][]{
                {1550.52, 2423.5, 3757685.000},
                {-1450.02, -71.80, 104111.000},
                {0.0, 0.0, 0.0}
        });
    }
}

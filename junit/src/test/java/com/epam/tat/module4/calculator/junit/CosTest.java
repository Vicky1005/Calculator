package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class CosTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Cos operation of {0}")
    @MethodSource("valuesForCosTest")
    public void cosTest(double a, double expectedResult) {
        double result = calculator.cos(a);
        Assertions.assertEquals(result, expectedResult, 0.001, "Invalid result of cos operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForCosTest() {
        return Arrays.asList(new Object[][]{
                {9.8, -0.930},
                {-10.85, -0.145},
                {0.0, 1.0},
                {Math.PI, -1.0}
        });
    }
}

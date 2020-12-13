package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class CtgTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Ctg operation of {0}")
    @MethodSource("valuesForCtgTest")
    public void ctgTest(double a, double expectedResult) {
        double result = calculator.ctg(a);
        Assertions.assertEquals(result, expectedResult, 0.001, "Invalid result of ctg operation");

    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForCtgTest() {
        return Arrays.asList(new Object[][]{
                {9.8, 2.538},
                {-10.85, -0.146},
                {0.0, Double.POSITIVE_INFINITY},
                {Math.PI, -8.165}
        });
    }
}

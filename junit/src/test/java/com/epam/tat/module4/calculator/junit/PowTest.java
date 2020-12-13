package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class PowTest extends BaseTest {

    @Tag("pow")
    @ParameterizedTest(name = " #{index} Pow operation: {0} to the power of {1}")
    @MethodSource("valuesForPowTest")
    public void powTest(double a, double b, double expectedResult) {
        double result = calculator.pow(a, b);
        Assertions.assertEquals(result, expectedResult, 0.001, "Invalid result of pow operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForPowTest() {
        return Arrays.asList(new Object[][]{
                {9.8, 4.1, 9223.681},
                {-10.85, -2.0, 0.008},
                {0.0, 0.0, 1.000},
        });
    }
}

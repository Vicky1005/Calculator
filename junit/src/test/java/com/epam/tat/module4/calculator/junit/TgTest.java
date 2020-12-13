package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Double.NaN;

public class TgTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Tg operation of {0}")
    @MethodSource("valuesForTg")
    public void tgTest(double a, double expectedResult) {
        double result = calculator.tg(a);
        Assertions.assertEquals(result, expectedResult, "Invalid result of tg operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForTg() {
        return Arrays.asList(new Object[][]{
                {180.0, 1.0},
                {-10.85, 1.0},
                {0.0, NaN},
                {Math.PI, 1.0}
        });
    }
}

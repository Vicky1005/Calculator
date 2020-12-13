package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class SubDoubleTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Sub double operation {0}-{1}")
    @MethodSource("valuesForSubDoubleTest")
    public void subDouble(double a, double b, double expectedResult) {
        double result = calculator.sub(a, b);
        Assertions.assertEquals(result, expectedResult, "Invalid result of sub operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForSubDoubleTest() {
        return Arrays.asList(new Object[][]{
                {1047.8, 23825.125, -22777.325},
                {-710.622, -152.985, -557.637},
                {0.0, 0.0, 0.000},
        });
    }
}

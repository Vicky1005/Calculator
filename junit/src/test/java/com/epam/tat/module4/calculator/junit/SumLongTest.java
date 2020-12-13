package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class SumLongTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Sum long operation {0}-{1}")
    @MethodSource("valuesForSumLong")
    public void sumLong(long a, long b, long expectedResult) {
        long result = calculator.sum(a, b);
        Assertions.assertEquals(result, expectedResult, "Invalid result of sum operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForSumLong() {
        return Arrays.asList(new Object[][]{
                {859L, 1693L, 2552L},
                {-1082L, -8523L, -9605L},
                {0L, 0L, 0L},
        });
    }
}

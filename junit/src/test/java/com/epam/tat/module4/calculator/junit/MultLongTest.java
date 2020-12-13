package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class MultLongTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Mult long operation {0}*{1}")
    @MethodSource("valuesForMultLong")
    public void multLong(long a, long b, long expectedResult) {
        long result = calculator.mult(a, b);
        Assertions.assertEquals(result, expectedResult, "Invalid result of mult operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForMultLong() {
        return Arrays.asList(new Object[][]{
                {11450L, 235L, 2690750L},
                {-25868L, -255755L, 6615870340L},
                {0L, 0L, 0L},
        });
    }
}

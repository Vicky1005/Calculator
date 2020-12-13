package com.epam.tat.module4.calculator.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class SubLongTest extends BaseTest {

    @ParameterizedTest(name = " #{index} Sub long operation {0}-{1}")
    @MethodSource("valuesForSubLong")
    public void subLong(long a, long b, long expectedResult) {
        long result = calculator.sub(a, b);
        Assertions.assertEquals(result, expectedResult, "Invalid result of sub operation");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuesForSubLong() {
        return Arrays.asList(new Object[][]{
                {17150L, 24843L, -7693L},
                {-14190L, -1545L, -12645L},
                {0L, 0L, 0L},
        });
    }
}

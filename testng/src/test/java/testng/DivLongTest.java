package testng;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DivLongTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForDivLongTest")
    public void divLong(long a, long b, long expectedResult) {
        long result = calculator.div(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of div operation");
    }

    @Test(dataProvider = "valuesForDivLongByZeroTest")
    public void divLongByZero(long a, long b) {
        Assert.assertThrows(NumberFormatException.class, () -> calculator.div(a, b));
    }

    @DataProvider(name = "valuesForDivLongTest")
    public Object[][] valuesForDivLong() {
        return new Object[][]{
                {15245650L, 65565L, 232L},
                {-105615L, -152L, 694L}
        };
    }

    @DataProvider(name = "valuesForDivLongByZeroTest")
    public Object[][] valuesForDivLongByZeroTest() {
        return new Object[][]{
                {151516L, 0L},
                {-105615L, 0L},
                {0L, 0L}
        };
    }

    @BeforeMethod()
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Div long operation " + testData[0] + "/" + testData[1] + " ");
    }
}


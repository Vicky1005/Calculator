package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SumLongTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForSumLongTest", groups = "sumL")
    public void sumLong(long a, long b, long expectedResult) {
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sum operation");
    }

    @DataProvider(name = "valuesForSumLongTest")
    public Object[][] valuesForSumLong() {
        return new Object[][]{
                {859L, 1693L, 2552L},
                {-1082L, -8523L, -9605L},
                {0L, 0L, 0L},
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Sum long operation " + testData[0] + "+" + testData[1] + " ");
    }
}

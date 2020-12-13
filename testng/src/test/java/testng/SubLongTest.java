package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SubLongTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForSubLongTest")
    public void subLong(long a, long b, long expectedResult) {
        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sub operation");
    }

    @DataProvider(name = "valuesForSubLongTest")
    public Object[][] valuesForSubLong() {
        return new Object[][]{
                {17150L, 24843L, -7693L},
                {-14190L, -1545L, -12645L},
                {0L, 0L, 0L},
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Sub long operation  " + testData[0] + "-" + testData[1] + " ");
    }
}

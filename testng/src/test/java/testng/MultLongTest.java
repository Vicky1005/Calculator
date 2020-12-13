package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MultLongTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForMultLongTest", groups = "arithmetic_operation")
    public void multLong(long a, long b, long expectedResult) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of mult operation");
    }

    @DataProvider(name = "valuesForMultLongTest")
    public Object[][] valuesForMultLong() {
        return new Object[][]{
                {11450L, 235L, 2690750L},
                {-25868L, -255755L, 6615870340L},
                {0L, 0L, 0L},
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Mult long operation " + testData[0] + "*" + testData[1] + " ");
    }
}

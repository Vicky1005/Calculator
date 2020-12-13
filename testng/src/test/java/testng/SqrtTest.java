package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SqrtTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForSqrtTest", groups = "sqrt")
    public void sqrtTest(double a, double expectedResult) {
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, expectedResult, 0.01, "Invalid result of sqrt operation");
    }

    @DataProvider(name = "valuesForSqrtTest")
    public Object[][] valuesForSqrt() {
        return new Object[][]{
                {9.8, 3.13},
                {-10.85, 3.29},
                {0.0, 0.0},
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Sqrt operation of " + testData[0] + " ");
    }
}

package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SinTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForSinTest")
    public void sinTest(double a, double expectedResult) {
        double result = calculator.sin(a);
        Assert.assertEquals(result, expectedResult, 0.1, "Invalid result of sin operation");
    }

    @DataProvider(name = "valuesForSinTest")
    public Object[][] valuesForSin() {
        return new Object[][]{
                {9.8, -0.366},
                {-10.85, 0.989},
                {0.0, 0.0},
                {Math.PI, 1.2246467991473532E-16}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Sin operation of " + testData[0] + " ");
    }
}

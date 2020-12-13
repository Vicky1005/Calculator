package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class PowTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForPowTest", groups = "pow")
    public void powTest(double a, double b, double expectedResult) {
        double result = calculator.pow(a, b);
        Assert.assertEquals(result, expectedResult, 0.01, "Invalid result of pow operation");
    }

    @DataProvider(name = "valuesForPowTest")
    public Object[][] valuesForPow() {
        return new Object[][]{
                {9.8, 4.1, 9223.68},
                {-10.85, -2.0, 0.00},
                {0.0, 0.0, 1.00},
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Pow operation of " + testData[0] + " ");
    }
}

package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SumDoubleTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForSumDoubleTest", groups = "sumD")
    public void sumDouble(double a, double b, double expectedResult) {
        double result = calculator.sum(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sum operation");
    }

    @DataProvider(name = "valuesForSumDoubleTest")
    public Object[][] valuesForSumDouble() {
        return new Object[][]{
                {1082.587, 237.66, 1320.247,},
                {-7410.071, -15255.020, -22665.091},
                {0.00, 0.000, 0.0}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Sum double operation " + testData[0] + "+" + testData[1] + " ");
    }
}

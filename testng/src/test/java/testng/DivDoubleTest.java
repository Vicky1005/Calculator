package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DivDoubleTest extends BaseTest implements MethodName {
    @Test(dataProvider = "valuesForDivDoubleByZeroTest")
    public void divDoubleByZero(double a, double b, double expectedResult) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of div operation");
    }

    @Test(dataProvider = "valuesForDivDoubleTest", groups = "arithmetic_operation")
    public void divLong(double a, double b, double expectedResult) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expectedResult, 0.001, "Invalid result of div operation");
    }

    @DataProvider(name = "valuesForDivDoubleTest")
    public Object[][] valuesForDivDouble() {
        return new Object[][]{
                {15047585.35, 6858.010, 2194.162},
                {-1156.10, -7.800, 148.217}
        };
    }

    @DataProvider(name = "valuesForDivDoubleByZeroTest")
    public Object[][] valuesForDivDoubleByZero() {
        return new Object[][]{
                {-520.63, 0, Double.NEGATIVE_INFINITY},
                {1156.10, 0, Double.POSITIVE_INFINITY}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Div double operation " + testData[0] + "/" + testData[1] + " ");
    }
}

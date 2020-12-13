package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MultDoubleTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForMultDoubleTest")
    public void multDouble(double a, double b, double expectedResult) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedResult, 0.1, "Invalid result of mult operation");
    }

    @DataProvider(name = "valuesForMultDoubleTest")
    public Object[][] valuesForMultDouble() {
        return new Object[][]{
                {1550.52, 2423.5, 3757685.0},
                {-1450.02, -71.80, 104111.0},
                {0.0, 0.0, 0.0}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Mult double operation " + testData[0] + "*" + testData[1] + " ");
    }
}

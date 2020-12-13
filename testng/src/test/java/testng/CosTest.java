package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CosTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForCosTest")
    public void cosTest(double a, double expectedResult) {
        double result = calculator.cos(a);
        Assert.assertEquals(result, expectedResult, 0.1, "Invalid result of cos operation");
    }

    @DataProvider(name = "valuesForCosTest")
    public Object[][] valuesForCos() {
        return new Object[][]{
                {9.8, -0.9},
                {-10.85, -0.1},
                {0.0, 1.0},
                {Math.PI, -1.0}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Cos operation of " + testData[0] + " ");
    }
}

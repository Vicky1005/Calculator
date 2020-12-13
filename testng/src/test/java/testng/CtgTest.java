package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CtgTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForCtgTest")
    public void ctgTest(double a, double expectedResult) {
        double result = calculator.ctg(a);
        Assert.assertEquals(result, expectedResult, 0.001, "Invalid result of ctg operation");

    }

    @DataProvider(name = "valuesForCtgTest")
    public Object[][] valuesForCtg() {
        return new Object[][]{
                {9.8, 2.538},
                {-10.85, -0.146},
                {0.0, Double.POSITIVE_INFINITY},
                {Math.PI, -8.165}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Ctg operation of " + testData[0] + " ");
    }
}

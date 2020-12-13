package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TgTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForTgTest", groups = "trigonometric_function")
    public void tgTest(double a, double expectedResult) {
        double result = calculator.tg(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of tg operation");
    }

    @DataProvider(name = "valuesForTgTest")
    public Object[][] valuesForTg() {
        return new Object[][]{
                {180.0, 1.338},
                {-10.85, -6.820},
                {0.0, 0.0},
                {Math.PI, -1.224}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Tg operation  of " + testData[0] + " ");
    }
}

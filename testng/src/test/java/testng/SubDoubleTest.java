package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SubDoubleTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForSubDoubleTest")
    public void subDouble(double a, double b, double expectedResult) {
        double result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sub operation");
    }

    @DataProvider(name = "valuesForSubDoubleTest")
    public Object[][] valuesForSubDoubleTest() {
        return new Object[][]{
                {1047.8, 23825.125, -22777.325},
                {-710.622, -152.985, -557.637},
                {0.0, 0.0, 0.0},
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Sub double operation  " + testData[0] + "-" + testData[1] + " ");
    }
}

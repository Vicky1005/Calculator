package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class IsNegative extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForIsNegativeTestTrue")
    public void isNegativeTrue(long a) {
        boolean isNegative = calculator.isNegative(a);
        Assert.assertTrue(isNegative, "Invalid data for isNegative operation");
    }

    @Test(dataProvider = "valuesForIsNegativeTestFalse")
    public void isNegativeFalse(long a) {
        boolean isNegative = calculator.isNegative(a);
        Assert.assertFalse(isNegative, "Invalid data for isNegative operation");
    }

    @DataProvider(name = "valuesForIsNegativeTestTrue")
    public Object[][] valuesForIsNegativeTestTrue() {
        return new Object[][]{
                {-25151L}
        };
    }

    @DataProvider(name = "valuesForIsNegativeTestFalse")
    public Object[][] valuesForIsNegativeTestFalse() {
        return new Object[][]{
                {15623616L},
                {0L}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Verify if " + testData[0] + " value is negative ");
    }
}

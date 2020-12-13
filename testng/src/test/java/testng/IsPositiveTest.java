package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class IsPositiveTest extends BaseTest implements MethodName {

    @Test(dataProvider = "valuesForIsPositiveTestFalse")
    public void isPositiveFalse(long a) {
        boolean isPositive = calculator.isPositive(a);
        Assert.assertFalse(isPositive, "Invalid data for isPositive operation");
    }

    @Test(dataProvider = "valuesForIsPositiveTestTrue")
    public void isPositiveTrue(long a) {
        boolean isPositive = calculator.isPositive(a);
        Assert.assertTrue(isPositive, "Invalid data for isPositive operation");
    }

    @DataProvider(name = "valuesForIsPositiveTestTrue")
    public Object[][] valuesForIsPositiveTestTrue() {
        return new Object[][]{
                {15623616L}
        };
    }

    @DataProvider(name = "valuesForIsPositiveTestFalse")
    public Object[][] valuesForIsPositiveTestFalse() {
        return new Object[][]{
                {-25151L},
                {0L}
        };
    }

    @BeforeMethod
    @Override
    public void beforeMethod(Method method, Object[] testData) {
        testName.set("Verify if " + testData[0] + " value is positive ");
    }
}

package testng;

import org.testng.ITest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public interface MethodName extends ITest {

    ThreadLocal<String> testName = new ThreadLocal<>();

    @BeforeMethod
    void beforeMethod(Method method, Object[] testData);

    default String getTestName() {
        return testName.get();
    }
}


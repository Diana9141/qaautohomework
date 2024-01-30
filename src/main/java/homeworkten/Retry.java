package homeworkten;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (result.getThrowable() instanceof org.testng.internal.thread.ThreadTimeoutException && retryCount < maxRetryCount) {
            retryCount++;
            return true; // Повторить тест
        }
        return false; // Не повторять тест
    }
}


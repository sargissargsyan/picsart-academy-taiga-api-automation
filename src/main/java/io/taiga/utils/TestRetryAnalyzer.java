package io.taiga.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer {
    private final ConfigManager config = ConfigManager.getInstance();
    private int retryCount = 0;
    private final int maxRetryCount;

    public TestRetryAnalyzer() {
        this.maxRetryCount = config.getIntProperty("test.retry.count", 2);
    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getMethod().getMethodName() + 
                             " (Attempt " + (retryCount + 1) + " of " + (maxRetryCount + 1) + ")");
            return true;
        }
        return false;
    }
}
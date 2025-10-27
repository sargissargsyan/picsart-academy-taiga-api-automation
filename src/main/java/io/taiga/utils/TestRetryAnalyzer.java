package io.taiga.utils;

import lombok.extern.java.Log;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log
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
            log.info("Retrying test: " + result.getMethod().getMethodName() + 
                    " (Attempt " + (retryCount + 1) + " of " + (maxRetryCount + 1) + ")");
            log.warning("Test failed with exception: " + result.getThrowable());
            return true;
        }
        log.severe("Test " + result.getMethod().getMethodName() + " failed after " + 
                  (maxRetryCount + 1) + " attempts");
        return false;
    }
}
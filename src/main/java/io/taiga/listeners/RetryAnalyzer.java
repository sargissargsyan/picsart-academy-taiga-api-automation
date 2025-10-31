package io.taiga.listeners;

import io.taiga.utils.ConfigManager;
import lombok.extern.java.Log;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = ConfigManager.getInstance().getIntProperty("retry.count", 2);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            log.info("Retrying test: " + iTestResult.getName() + " for the " + retryCount + " time");
            return true;
        }
        log.info("Test " + iTestResult.getName() + " failed after " + maxRetryCount + " retries");
        return false;
    }
}

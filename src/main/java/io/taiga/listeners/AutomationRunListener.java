package io.taiga.listeners;

import lombok.extern.java.Log;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log
public class AutomationRunListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("------------------------------------------------------------");
        log.info("Starting test: " + result.getMethod().getQualifiedName());
        log.info("------------------------------------------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("------------------------------------------------------------");
        log.info("Test " + result.getMethod().getQualifiedName() + " PASSED");
        log.info("------------------------------------------------------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("------------------------------------------------------------");
        log.info("Test " + result.getMethod().getQualifiedName() + " FAILED");
        log.info("------------------------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("------------------------------------------------------------");
        log.info("Test " + result.getMethod().getQualifiedName() + " SKIPPED");
        log.info("------------------------------------------------------------");
    }

}

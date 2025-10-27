package io.taiga;

import io.taiga.utils.TestRetryAnalyzer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestClass {
    @Test(retryAnalyzer = TestRetryAnalyzer.class)
    public void test() {
        System.out.println("test");
        assertTrue(false);
    }
}

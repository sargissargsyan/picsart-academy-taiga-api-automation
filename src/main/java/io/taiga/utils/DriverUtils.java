package io.taiga.utils;

import io.qameta.allure.Attachment;
import io.taiga.selenium.factory.DriverFactory;
import lombok.extern.java.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


@Log
public class DriverUtils {

    @Attachment(value = "Failure in method {0}", type = "image/png")
    public static byte[] takeScreenShot(String methodName) {
        log.info("Taking screenshot on failure");
        return ((TakesScreenshot)DriverFactory.get().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

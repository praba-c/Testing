package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

public class Screenshot {

    public static void takeScreenshot(WebDriver driver, int num) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "Screenshot_" + num;
        try {
            copyFile(file, new File("FailedCases/" + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

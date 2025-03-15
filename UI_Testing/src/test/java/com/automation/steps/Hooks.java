package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    static int number = 1;

    @Before
    public static void startUp() {
        ConfigReader.initReader();
        DriverManager.createDriver();
    }

    @After
    public static void clean(Scenario scenario) {
        if (scenario.isFailed()) {
            Screenshot.takeScreenshot(DriverManager.getDriver(), number);
            number++;
        }
        DriverManager.getDriver().quit();
    }
}

package com.sarath.appium.hooks;

import com.sarath.appium.base.BaseTest;
import com.sarath.appium.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        BaseTest.initializeDriver();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (BaseTest.driver != null) {
            // 1. Capture Screenshot for Extent Reports if failed
            if (scenario.isFailed()) {
                try {
                    final byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failed Step: " + scenario.getName());
                } catch (Exception e) {
                    System.err.println("Failed to capture screenshot: " + e.getMessage());
                }
            }

            // 2. Sync Status with LambdaTest (Industry Standard)
            String env = ConfigReader.getProperty("executionEnv");
            if ("cloud".equalsIgnoreCase(env)) {
                try {
                    String status = scenario.isFailed() ? "failed" : "passed";
                    ((JavascriptExecutor) BaseTest.driver).executeScript("lambda-status=" + status);
                } catch (Exception e) {
                    System.err.println("Could not update LambdaTest status: " + e.getMessage());
                }
            }

            System.out.println("Closing session for: " + scenario.getName());
            BaseTest.quitDriver();
        }
    }
}
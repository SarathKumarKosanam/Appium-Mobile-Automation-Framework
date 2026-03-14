package com.sarath.appium.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.sarath.appium.stepDefs", "com.sarath.appium.hooks"},
        plugin = {"pretty",
                "html:reports/cucumber-reports/today-report.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //Extent Reprot Plugin this will automatically generate the reports with help of extent.properties file

        monochrome = true

)
public class TestRunner extends AbstractTestNGCucumberTests {}
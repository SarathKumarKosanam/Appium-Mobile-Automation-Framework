package com.sarath.appium.base;

import com.sarath.appium.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static AndroidDriver driver;

    public static void initializeDriver() throws Exception {
        String executionEnv = System.getProperty("executionEnv") != null
                ? System.getProperty("executionEnv")
                : ConfigReader.getProperty("executionEnv");

        UiAutomator2Options options = new UiAutomator2Options();
        URL url;

        if ("cloud".equalsIgnoreCase(executionEnv)) {
            String ltUsername = System.getProperty("LT_USERNAME") != null
                    ? System.getProperty("LT_USERNAME")
                    : ConfigReader.getProperty("lt_username");

            String ltAccessKey = System.getProperty("LT_ACCESS_KEY") != null
                    ? System.getProperty("LT_ACCESS_KEY")
                    : ConfigReader.getProperty("lt_access_key");

            HashMap<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "Android");
            ltOptions.put("deviceName", ConfigReader.getProperty("lt_deviceName"));
            ltOptions.put("platformVersion", ConfigReader.getProperty("lt_platformVersion"));
            ltOptions.put("app", ConfigReader.getProperty("lt_app_url"));

            // Ensure this is a boolean, not a string
            boolean isReal = Boolean.parseBoolean(ConfigReader.getProperty("isRealMobile"));
            ltOptions.put("isRealMobile", isReal);

            ltOptions.put("project", "Android_Automation_Framework");
            ltOptions.put("build", "Build_v2.0");
            ltOptions.put("name", "LambdaTest_Execution");
            ltOptions.put("visual", true);
            ltOptions.put("video", true);
            ltOptions.put("network", false);

            // Set main capability to ensure platform consistency
            options.setCapability("platformName", "Android");
            options.setCapability("lt:options", ltOptions);

            url = new URL("https://" + ltUsername + ":" + ltAccessKey + "@mobile-hub.lambdatest.com/wd/hub");

        } else {
            String projectRoot = System.getProperty("user.dir");
            String relativeAppPath = ConfigReader.getProperty("appLocation");
            String fullAppPath = projectRoot + relativeAppPath.replace("/", File.separator).replace("\\", File.separator);

            options.setDeviceName(ConfigReader.getProperty("deviceName"))
                    .setApp(fullAppPath)
                    .setAppPackage(ConfigReader.getProperty("appPackage"))
                    .setAppActivity(ConfigReader.getProperty("appActivity"))
                    .setNoReset(false)
                    .setAutomationName("UiAutomator2");

            url = new URL(ConfigReader.getProperty("localAppiumUrl"));
        }

        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
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
        // Read environment from config: 'local' or 'cloud'
        String executionEnv = ConfigReader.getProperty("executionEnv");
        UiAutomator2Options options = new UiAutomator2Options();
        URL url;

        if ("cloud".equalsIgnoreCase(executionEnv)) {
            // --- LambdaTest Cloud Configuration ---
            String ltUsername = ConfigReader.getProperty("lt_username");
            String ltAccessKey = ConfigReader.getProperty("lt_access_key");

            HashMap<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", ConfigReader.getProperty("lt_deviceName"));
            ltOptions.put("platformVersion", ConfigReader.getProperty("lt_platformVersion"));
            ltOptions.put("app", ConfigReader.getProperty("lt_app_url")); // lt://APP_ID
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "Android_Automation_Framework");
            ltOptions.put("build", "Build_v1.0");
            ltOptions.put("name", "Cucumber_Automation_Run");
            ltOptions.put("visual", true); // To enable screenshots on LambdaTest dashboard
            ltOptions.put("video", true);  // To record video of execution

            options.setCapability("lt:options", ltOptions);
            url = new URL("https://" + ltUsername + ":" + ltAccessKey + "@mobile-hub.lambdatest.com/wd/hub");

        } else {
            // --- Local Execution Configuration ---
            String projectRoot = System.getProperty("user.dir");
            String relativeAppPath = ConfigReader.getProperty("appLocation");
            String fullAppPath = projectRoot + relativeAppPath.replace("/", File.separator).replace("\\", File.separator);

            options.setDeviceName(ConfigReader.getProperty("deviceName"))
                    .setApp(fullAppPath)
                    .setAppPackage(ConfigReader.getProperty("appPackage"))
                    .setAppActivity(ConfigReader.getProperty("appActivity"))
                    .setNoReset(false)
                    .setAutomationName("UiAutomator2");

            url = new URL(ConfigReader.getProperty("localAppiumUrl")); // e.g., http://127.0.0.1:4723
        }

        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
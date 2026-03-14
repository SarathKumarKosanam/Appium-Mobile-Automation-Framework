package com.sarath.appium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static Properties initializeProperties() {
        properties = new Properties();
        // Construct path using user.dir for maximum cross-platform compatibility
        String configPath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

        try (FileInputStream ip = new FileInputStream(configPath)) {
            properties.load(ip);
        } catch (IOException e) {
            System.err.println("CRITICAL: Could not load config.properties at: " + configPath);
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key) {
        if (properties == null) {
            initializeProperties();
        }
        return properties.getProperty(key);
    }
}
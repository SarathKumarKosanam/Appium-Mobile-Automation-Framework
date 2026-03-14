package com.sarath.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void handleOTAPopup() {
        try {
            // Use a short wait so it doesn't slow down the test if the popup isn't there
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement yesBtn = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")));
            yesBtn.click();
            System.out.println("OTA Popup detected and accepted.");
        } catch (Exception e) {
            // If not found, just continue the test
        }
    }


    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void typeText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
}


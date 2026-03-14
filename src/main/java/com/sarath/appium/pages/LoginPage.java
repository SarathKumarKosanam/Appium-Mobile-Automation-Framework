package com.sarath.appium.pages;

import com.sarath.appium.base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // Using Accessibility ID (content-desc) for ApiDemos
    @AndroidFindBy(accessibility = "Views")
    private WebElement viewsOption;

    @AndroidFindBy(accessibility = "Buttons")
    private WebElement buttonsOption;

    @AndroidFindBy(accessibility = "Normal")
    private WebElement normalButton;

    public LoginPage() {
        super(BaseTest.driver);
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    public void navigateToViews() {
        handleOTAPopup(); // Safety check for system dialogs
        clickElement(viewsOption);
    }

    public void clickButtonsOption() {
        clickElement(buttonsOption);
    }

    public boolean isNormalButtonDisplayed() {
        return normalButton.isDisplayed();
    }
}
package com.sarath.appium.pages;

import com.sarath.appium.base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    @AndroidFindBy(accessibility = "App")
    private WebElement appMenu;

    @AndroidFindBy(accessibility = "Search")
    private WebElement searchMenu;

    // INTENTIONAL FAILURE: This ID does not exist in the Search menu
    @AndroidFindBy(id = "io.appium.android.apis:id/btn_clear_history_fake")
    private WebElement clearHistoryBtn;

    public SearchPage() {
        super(BaseTest.driver);
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    public void navigateToSearch() {
        clickElement(appMenu);
        clickElement(searchMenu);
    }

    public void clickClearHistory() {
        // This will trigger the 10-second wait and then FAIL
        clickElement(clearHistoryBtn);
    }
}
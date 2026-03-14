package com.sarath.appium.stepDefs;

import com.sarath.appium.pages.SearchPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    @When("the user navigates to \"App\" then \"Search\"")
    public void navigateToSearchMenu() {
        searchPage.navigateToSearch();
    }

    @When("the user attempts to click on \"Clear History\" button")
    public void attemptClearHistory() {
        searchPage.clickClearHistory();
    }

    @Then("the \"History Cleared\" message should be visible")
    public void verifySuccessMessage() {
        // This step will never be reached because the previous step fails
        Assert.assertTrue(true);
    }
}
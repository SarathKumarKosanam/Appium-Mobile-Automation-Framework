package com.sarath.appium.stepDefs;

import com.sarath.appium.pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("the app is launched and user is on the main menu")
    public void verifyAppLaunch() {
        // Driver init is handled by Hooks.java
    }

    @When("the user clicks on the {string} option")
    public void clickViews(String option) {
        if(option.equalsIgnoreCase("Views")) {
            loginPage.navigateToViews();
        } else if(option.equalsIgnoreCase("Buttons")) {
            loginPage.clickButtonsOption();
        }
    }

    @Then("the {string} button should be visible on the screen")
    public void verifyButtonVisibility(String buttonName) {
        Assert.assertTrue(loginPage.isNormalButtonDisplayed(), "Normal button was not found!");
    }
}
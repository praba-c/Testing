package com.automation.steps;

import com.automation.page.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens the application")
    public void userOpensTheApplication() {
        homePage.userOpensApplication();
    }

    @Then("verify home page is displayed")
    public void verifyHomePageIsDisplayed() {
        Assert.assertTrue(homePage.verifyHomePageDisplayed());
    }

    @When("user clicks on flights tab")
    public void userClicksOnFlightsTab() {
        homePage.clickOnFlightsTab();
    }

    @And("selects {string}, {string} and {string}, {string}")
    public void selectsAndAnd(String fromCity, String toCity, String date, String adultCount) {
        homePage.selectFromCity(fromCity);
        homePage.selectDestinationCity(toCity);
        homePage.selectDate(date);
        homePage.selectNumberOfTravellers(adultCount);
    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        homePage.clickOnSearchButton();
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        homePage.clickOnLoginBtn();
    }

    @And("selects customer login button")
    public void selectsCustomerLoginButton() {
        homePage.selectCustomerLogin();
    }

    @Then("verify popup asking for mobile number is displayed")
    public void verifyPopupAskingForMobileNumberIsDisplayed() {
        Assert.assertTrue(homePage.isPopupDisplayed());
    }

    @When("user enters {string}")
    public void userEnters(String mobileNumber) {
        homePage.enterMobileNumber(mobileNumber);
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        homePage.clickOnContinueBtn();
    }

    @Then("verify otp is generated")
    public void verifyOtpIsGenerated() {
        Assert.assertTrue(homePage.isOtpGenerated());
    }
}

package com.automation.steps;

import com.automation.page.FlightDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightDetailSteps {

    FlightDetailPage flightDetailPage = new FlightDetailPage();

    @Then("verify flight detail page is displayed")
    public void verifyFlightDetailPageIsDisplayed() {
        Assert.assertTrue(flightDetailPage.isFlightDetailPageDisplayed());
    }

    @And("print the price details")
    public void printThePriceDetails() {
        flightDetailPage.printPriceDetails();
    }

    @When("user enters the {string}")
    public void userEntersThe(String email) {
        flightDetailPage.enterEmail(email);
    }

    @And("fills the {string}, {string}, {string}, {string} and clicks on continue booking button")
    public void fillsTheTravellersDetailsAndClicksOnContinueBookingButton(String title, String firstName, String lastName, String mobileNumber) {
        flightDetailPage.fillDetails(title, firstName, lastName, mobileNumber);
    }

    @Then("verify payment page is displayed")
    public void verifyPaymentPageIsDisplayed() {
    }
}

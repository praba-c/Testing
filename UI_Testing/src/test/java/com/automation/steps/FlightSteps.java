package com.automation.steps;

import com.automation.page.FlightPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightSteps {

    FlightPage flightPage = new FlightPage();

    @Then("verify flights page is displayed")
    public void verifyFlightsPageIsDisplayed() {
        Assert.assertTrue(flightPage.isFlightPageDisplayed());
    }


    @When("user select {string} from the filters tab")
    public void userSelectFromTheFiltersTab(String flightName) {
        flightPage.selectFilterOption(flightName);
    }


    @Then("verify flights are displayed based on the applied filter {string}")
    public void verifyFlightsAreDisplayedBasedOnTheAppliedFilter(String flightName) {
        Assert.assertTrue(flightPage.isFlightsDisplayedWithFilter(flightName));
    }

    @When("user selects a flight")
    public void userSelectsAFlight() {
        flightPage.clickBookNowButton();
    }
}

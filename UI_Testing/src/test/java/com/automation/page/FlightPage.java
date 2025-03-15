package com.automation.page;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightPage extends BasePage{

    @FindBy(xpath = "//div[@deptm and not(@style='display: none;')]//span[contains(@ng-bind,'GetAirLineName')]")
    List<WebElement> listOfFlightNames;

    @FindBy(xpath = "//div[@class='prc_val airl1-sec'][1]//label")
    List<WebElement> filterOptionValues;


    public boolean isFlightPageDisplayed() {
        return !listOfFlightNames.isEmpty();
    }

    public void selectFilterOption(String filterOption) {
        for (WebElement filter : filterOptionValues) {
            if (!filter.getText().trim().equalsIgnoreCase(ConfigReader.getConfigValue(filterOption))) {
                if (filter.findElement(By.xpath("./input")).isSelected()) {
                    filter.click();
                }
            } else {
                if (!filter.findElement(By.xpath("./input")).isSelected()) {
                    filter.click();
                }
            }
        }
    }

    public boolean isFlightsDisplayedWithFilter(String filterOption) {
        for (WebElement flight : listOfFlightNames) {
            if (!flight.getText().equalsIgnoreCase(ConfigReader.getConfigValue(filterOption))) {
                return false;
            }
        }
        return true;
    }

    public void clickBookNowButton() {
        WebElement bookNowBtn = listOfFlightNames.getFirst().findElement(By.xpath("./ancestor::div[3]/following-sibling::div//button"));
        bookNowBtn.click();
    }
}
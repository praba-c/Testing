package com.automation.page;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//i[@class='newHeaderLogo desk_logo']")
    WebElement logo;

    @FindBy(xpath = "//span[text()='Flights']")
    WebElement flightsTab;

    @FindBy(xpath = "//input[@id='FromSector_show']")
    WebElement fromCityTab;

    @FindBy(id = "a_FromSector_show")
    WebElement fromCityInputField;

    @FindBy(xpath = "//span[@class='flsctrhead']")
    List<WebElement> suggestedFromCities;

    @FindBy(id = "a_Editbox13_show")
    WebElement toCityInputField;

    @FindBy(xpath = "//input[@id='a_Editbox13_show']/../following-sibling::div//span[@class='flsctrhead']")
    List<WebElement> suggestedDestinationCities;

    @FindBy(xpath = "//input[@id='ddate']")
    WebElement dateTab;

    @FindBy(xpath = "//li[(@onclick='SelectDate(this.id)')and not (@class='old-dt')]")
    List<WebElement> availableDates;

    @FindBy(xpath = "//p[@id='ptravlrNo']")
    WebElement travelersTab;

    @FindBy(xpath = "//div[@id='field1']/button[@id='add']")
    WebElement adultAddBtn;

    @FindBy(xpath = "//a[@id='traveLer']")
    WebElement doneBtn;

    @FindBy(className = "srchBtnSe")
    WebElement searchBtn;

    @FindBy(xpath = "//span[text()='Login or Signup']")
    WebElement loginBtn;

    @FindBy(xpath = "//span[text()='Customer Login']")
    WebElement customerLoginBtn;

    @FindBy(xpath = "//input[@id='txtEmail']")
    WebElement mobileInputField;
    
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//div[text()='Otp Authentication']")
    WebElement otpPopUp;

    public void userOpensApplication() {
        driver.get("https://www.easemytrip.com/");
    }

    public boolean verifyHomePageDisplayed() {
        return logo.isDisplayed();
    }

    public void clickOnFlightsTab() {
        flightsTab.click();
    }

    public void selectFromCity(String inputCity) {
        fromCityTab.click();
        fromCityInputField.sendKeys(ConfigReader.getConfigValue(inputCity));

        pause(2000);
        for (WebElement city : suggestedFromCities) {

            wait.until(ExpectedConditions.elementToBeClickable(city));
            if (city.getText().contains(ConfigReader.getConfigValue(inputCity))) {
                city.click();
                break;
            }
        }
    }

    public void selectDestinationCity(String inputCity) {
        toCityInputField.sendKeys(ConfigReader.getConfigValue(inputCity));

        pause(2000);
        for (WebElement city : suggestedDestinationCities) {
            wait.until(ExpectedConditions.elementToBeClickable(city));
            if (city.getText().contains(ConfigReader.getConfigValue(inputCity))) {
                city.click();
                break;
            }
        }
    }

    public void selectDate(String inputDate) {

        for (WebElement date : availableDates) {
            if (date.getText().equalsIgnoreCase(ConfigReader.getConfigValue(inputDate))) {
                date.click();
                break;
            }
        }
    }

    public void selectNumberOfTravellers(String adultCount) {
        travelersTab.click();

        for (int i = 1; i < Integer.parseInt(ConfigReader.getConfigValue(adultCount)); ++i) {
            adultAddBtn.click();
        }

        doneBtn.click();
    }

    public void clickOnSearchButton() {
        searchBtn.click();
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }
    
    public void selectCustomerLogin() {
        customerLoginBtn.click();
    }
    
    public boolean isPopupDisplayed() {
        return mobileInputField.isDisplayed();
    }
    
    public void enterMobileNumber(String inputMobile) {
        mobileInputField.sendKeys(inputMobile);
    }
    
    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public boolean isOtpGenerated() {
        wait.until(ExpectedConditions.visibilityOf(otpPopUp));
        return otpPopUp.isDisplayed();
    }
}

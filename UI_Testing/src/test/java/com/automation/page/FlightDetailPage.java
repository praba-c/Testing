package com.automation.page;

import com.automation.utils.ConfigReader;
import io.cucumber.java.ja.且つ;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightDetailPage extends BasePage{

    @FindBy(id = "divFareSummary")
    WebElement priceDetails;

    @FindBy(xpath = "//input[@id='chkInsurance']")
    WebElement insuranceCheckBox;

    @FindBy(id = "txtEmailId")
    WebElement emailInputFiled;

    @FindBy(id = "spnVerifyEmail")
    WebElement continueBtn;

    @FindBy(xpath = "//span[@id='spnTransaction']")
    WebElement continueBookingBtn;

    @FindBy(xpath = "//label[text()='Title']/following-sibling::select")
    WebElement titleTab;

    @FindBy(xpath = "//select[@name='TitleAdult']/option")
    List<WebElement> titles;

    @FindBy(xpath = "//input[@placeholder='Enter First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Enter Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//div[@class='mob-r']/input")
    WebElement mobileNumber;

    public boolean isFlightDetailPageDisplayed() {
        return priceDetails.isDisplayed();
    }

    public void printPriceDetails() {
        System.out.println(priceDetails.getText());
    }

    public void enterEmail(String inputEmail) {
        insuranceCheckBox.click();
        emailInputFiled.sendKeys(ConfigReader.getConfigValue(inputEmail));
        continueBtn.click();
    }

    public void fillDetails(String inputTitle, String inputFirstName, String inputLastName, String inputMobile) {

        javascriptExecutor(titleTab);
        for (WebElement title : titles) {
            if (title.getText().equalsIgnoreCase(inputTitle)) {
                title.click();
            }
        }
        firstName.sendKeys(ConfigReader.getConfigValue(inputFirstName));
        lastName.sendKeys(ConfigReader.getConfigValue(inputLastName));
        mobileNumber.sendKeys(ConfigReader.getConfigValue(inputMobile));
        continueBookingBtn.click();
    }
}

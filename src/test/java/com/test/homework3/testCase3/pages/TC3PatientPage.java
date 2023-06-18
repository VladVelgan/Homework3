package com.test.homework3.testCase3.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class TC3PatientPage {

    public TC3PatientPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "givenName")
    WebElement firstNameInput;

    @FindBy (name = "familyName")
    WebElement lastNameInput;

    @FindBy (xpath = "//span[@id='genderLabel']")
    WebElement genderLabel;

    @FindBy (xpath = "//option[.='Male']")
    WebElement maleOption;

    @FindBy (xpath = "//span[.='Birthdate']")
    WebElement birthdateLabel;

    @FindBy (name = "birthdateDay")
    WebElement birthDayInput;

    @FindBy (name = "birthdateMonth") // "October"
    WebElement selectMonth;

    @FindBy (name = "birthdateYear")
    WebElement birthYearInput;

    @FindBy (xpath = "//span[.='Address']")
    WebElement addressLabel;

    @FindBy (xpath = "//input[@name='address1']")
    WebElement addressInput;

    @FindBy (xpath = "//input[@name='cityVillage']")
    WebElement cityInput;

    @FindBy (xpath = "//input[@name='stateProvince']") // stateProvince
    WebElement stateInput;

    @FindBy (xpath = "//input[@name='country']") // country
    WebElement countyInput;

    @FindBy (xpath = "//input[@name='postalCode']") // postalCode
    WebElement zipCodeInput;

    @FindBy (xpath = "//span[.='Phone Number']")
    WebElement phoneLabel;

    @FindBy (xpath = "//input[@name='phoneNumber']") // phoneNumber
    WebElement phoneInput;

    @FindBy (xpath = "//span[.='Confirm']")
    WebElement confirmLabel;

    @FindBy (xpath = "//div[@id='dataCanvas']//p")
    List<WebElement> newPatientInfo;

    @FindBy (css = "#submit")
    WebElement confirmSubmission;

    @FindBy (tagName = "h1") // if contains "Vlad Velgan"
    WebElement newPatientHeader;

    @FindBy (css = ".identifiers") // if contains "Patient ID"
    WebElement newPatientID;

    public void createNewPatientFunctionality(String firstName, String lastName, String gender,String birthDay, String birthMonth,
                                              String birthYear, String address, String city, String state,
                                              String county, String zipCode, String phone, String id) throws InterruptedException {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        genderLabel.click();
        Thread.sleep(500);
        maleOption.click();
        Thread.sleep(500);
        birthdateLabel.click();
        Thread.sleep(500);
        birthDayInput.sendKeys(birthDay);
        Select select = new Select(selectMonth);
        select.selectByVisibleText(birthMonth);
        birthYearInput.sendKeys(birthYear);
        addressLabel.click();
        Thread.sleep(500);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        countyInput.sendKeys(county);
        zipCodeInput.sendKeys(zipCode);
        phoneLabel.click();
        Thread.sleep(500);
        phoneInput.sendKeys(phone);
        confirmLabel.click();
        Thread.sleep(500);
        boolean infoIsCorrect = false;
        Thread.sleep(1000);
        for(WebElement input : newPatientInfo){
            if(BrowserUtils.getText(input).contains(firstName) || BrowserUtils.getText(input).contains(lastName)
                    || BrowserUtils.getText(input).contains(gender) || BrowserUtils.getText(input).contains(birthDay)
                    || BrowserUtils.getText(input).contains(birthMonth) || BrowserUtils.getText(input).contains(birthYear)
                    || BrowserUtils.getText(input).contains(address) || BrowserUtils.getText(input).contains(city)
                    || BrowserUtils.getText(input).contains(state) || BrowserUtils.getText(input).contains(county)
                    || BrowserUtils.getText(input).contains(zipCode) || BrowserUtils.getText(input).contains(phone)){
                infoIsCorrect = true;
            }
        }
        Assert.assertTrue(infoIsCorrect);
        confirmSubmission.click();
        Thread.sleep(500);
        Assert.assertTrue(BrowserUtils.getText(newPatientHeader).contains(firstName) &&
                BrowserUtils.getText(newPatientHeader).contains(lastName));
        Assert.assertTrue(BrowserUtils.getText(newPatientID).contains(id));
    }

}

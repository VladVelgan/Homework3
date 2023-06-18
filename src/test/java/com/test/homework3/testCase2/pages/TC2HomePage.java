package com.test.homework3.testCase2.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TC2HomePage {

    public TC2HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h4")
    WebElement actualHeader;

    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement selectLocationButton;

    @FindBy(xpath = "//li[.='Pharmacy']")
    WebElement locationPharmacy;

    @FindBy(css = ".logo")
    WebElement logo;

    @FindBy(css = ".icon-search")
    WebElement findPatientRecord;

    public void loginValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(actualHeader), expectedHeader);
    }

    public void changeLocationValidation(String changedHeader){
        selectLocationButton.click();
        locationPharmacy.click();
        logo.click();
        Assert.assertEquals(BrowserUtils.getText(actualHeader), changedHeader);
    }

    public void goToPatientRecord(){
        findPatientRecord.click();
    }

}

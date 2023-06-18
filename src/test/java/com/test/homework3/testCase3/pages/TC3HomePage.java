package com.test.homework3.testCase3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC3HomePage {

    public TC3HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[contains(.,'Register a patient')]")
    WebElement registerPatient;

    @FindBy (css = ".icon-home")
    WebElement homeButton;

    @FindBy(css = ".icon-search")
    WebElement findPatientRecord;

    public void selectRegisterPatient(){
        registerPatient.click();
    }

    public  void selectHome(){
        homeButton.click();
    }

    public void selectPatientRecords(){
        findPatientRecord.click();
    }

}

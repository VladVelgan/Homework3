package com.test.homework3.testCase2.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TC2PatientRecordPage {

    public TC2PatientRecordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr//td[1]")
    List<WebElement> allPatientsIdentifiers;

    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> allPatientsNames;

    String patientIdentifier;

    public String getPatientIdentifier(String patientName) throws InterruptedException {
        for (int i = 0; i < allPatientsNames.size(); i++){
            if(BrowserUtils.getText(allPatientsNames.get(i)).equals(patientName)){
                patientIdentifier = BrowserUtils.getText(allPatientsIdentifiers.get(i));
                break;
            }
        }
        return patientIdentifier;
    }

    public Boolean identifierIsUnique(String patientIdentifier) throws InterruptedException {
        int counter = 0;
        for(WebElement identifier : allPatientsIdentifiers){
            if(BrowserUtils.getText(identifier).equals(patientIdentifier)){
                counter++;
            }
        }
        return counter == 1;
    }



}

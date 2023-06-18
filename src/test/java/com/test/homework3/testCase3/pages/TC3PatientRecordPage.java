package com.test.homework3.testCase3.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class TC3PatientRecordPage {

    public TC3PatientRecordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//td[.='Vlad Velgan']")
    WebElement newPatient;

    @FindBy (xpath = "//li[contains(.,'Delete Patient')]")
    WebElement deletePatient;

    @FindBy (xpath = "//div[contains(@id,'delete-patient')]//div//button[@class='confirm right']")
    WebElement confirmDelete;

    @FindBy (css = "#delete-reason-empty")
    WebElement deleteMessage;

    @FindBy (css = "#delete-reason") // "Moved"
    WebElement reasonInput;

    @FindBy(xpath = "//tr//td[1]")
    List<WebElement> allPatientsIdentifiers;

    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> allPatientsNames;

    String patientIdentifier;

    public void findPatient(String firstName, String lastName) throws InterruptedException {
        boolean patientFound = false;
        for(WebElement patient : allPatientsNames){
            if(BrowserUtils.getText(patient).equals(firstName + " " + lastName)){
                patientFound = true;
            }
        }
        Assert.assertTrue(patientFound);
    }

    public String getPatientIdentifier(String firstName, String lastName) throws InterruptedException {
        for (int i = 0; i < allPatientsNames.size(); i++){
            if(BrowserUtils.getText(allPatientsNames.get(i)).equals(firstName + " " + lastName)){
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

    public void deletePatientFunctionality(String expectedDeleteMessage, String deleteReason, String firstName, String lastName){
        newPatient.click();
        deletePatient.click();
        confirmDelete.click();
        Assert.assertEquals(BrowserUtils.getText(deleteMessage), expectedDeleteMessage);
        reasonInput.sendKeys(deleteReason);
        confirmDelete.click();
        boolean patientWasDeleted = true;
        for(WebElement patient : allPatientsNames){
            if(BrowserUtils.getText(patient).contains(firstName) && BrowserUtils.getText(patient).contains(lastName)){
                patientWasDeleted = false;
                break;
            }
        }
        Assert.assertTrue(patientWasDeleted);
    }
}

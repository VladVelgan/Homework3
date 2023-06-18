package com.test.homework3.testCase3.tests;

import Utils.ConfigReader;
import com.test.homework3.testCase3.pages.TC3HomePage;
import com.test.homework3.testCase3.pages.TC3LoginPage;
import com.test.homework3.testCase3.pages.TC3PatientRecordPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC3PatientRecordTest extends TC3TestBase{

    @Parameters({"firstName", "lastName", "expectedDeleteMessage", "deleteReason"})
    @Test
    public void patientManipulationValidation(String firstName, String lastName, String expectedDeleteMessage,
                                              String deleteReason) throws InterruptedException {
        TC3LoginPage tc3LoginPage = new TC3LoginPage(driver);
        TC3HomePage tc3HomePage = new TC3HomePage(driver);
        TC3PatientRecordPage tc3PatientRecordPage = new TC3PatientRecordPage(driver);
        tc3LoginPage.loginFunctionality(ConfigReader.readProperty("QA_TC2_username"),
                ConfigReader.readProperty("QA_TC2_password"));
        tc3HomePage.selectPatientRecords();
        tc3PatientRecordPage.findPatient(firstName, lastName);
        Assert.assertTrue(tc3PatientRecordPage.identifierIsUnique
                (tc3PatientRecordPage.getPatientIdentifier(firstName, lastName)));
        tc3PatientRecordPage.deletePatientFunctionality(expectedDeleteMessage, deleteReason, firstName, lastName);
    }
}

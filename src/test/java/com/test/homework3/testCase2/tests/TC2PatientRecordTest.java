package com.test.homework3.testCase2.tests;

import Utils.ConfigReader;
import com.test.homework3.testCase2.pages.TC2HomePage;
import com.test.homework3.testCase2.pages.TC2LoginPage;
import com.test.homework3.testCase2.pages.TC2PatientRecordPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC2PatientRecordTest extends TC2TestBase{

    @Parameters({"patientName"})
    @Test
    public void validatePatientIdentifier(String patientName) throws InterruptedException {
        TC2LoginPage tc2LoginPage = new TC2LoginPage(driver);
        TC2HomePage tc2HomePage = new TC2HomePage(driver);
        TC2PatientRecordPage tc2PatientRecordPage = new TC2PatientRecordPage(driver);
        tc2LoginPage.loginFunctionality(ConfigReader.readProperty("QA_TC2_username"),
                ConfigReader.readProperty("QA_TC2_password"));
        tc2HomePage.goToPatientRecord();
        Assert.assertTrue(tc2PatientRecordPage.identifierIsUnique(tc2PatientRecordPage.getPatientIdentifier(patientName)));
    }
}

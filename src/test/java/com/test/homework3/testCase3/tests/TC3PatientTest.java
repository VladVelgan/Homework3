package com.test.homework3.testCase3.tests;

import Utils.ConfigReader;
import com.test.homework3.testCase3.pages.TC3HomePage;
import com.test.homework3.testCase3.pages.TC3LoginPage;
import com.test.homework3.testCase3.pages.TC3PatientPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC3PatientTest extends TC3TestBase{

    @Parameters({"firstName", "lastName", "gender", "birthDay", "birthMonth", "birthYear",
            "address", "city", "state", "county", "zipCode", "phone", "id"})
    @Test
    public void createNewPatientValidation(String firstName, String lastName, String gender, String birthDay,
                                           String birthMonth, String birthYear, String address, String city,
                                           String state, String county, String zipCode, String phone,
                                           String id) throws InterruptedException {
        TC3LoginPage tc3LoginPage = new TC3LoginPage(driver);
        TC3HomePage tc3HomePage = new TC3HomePage(driver);
        TC3PatientPage tc3PatientPage = new TC3PatientPage(driver);
        tc3LoginPage.loginFunctionality(ConfigReader.readProperty("QA_TC2_username"),
                ConfigReader.readProperty("QA_TC2_password"));
        tc3HomePage.selectRegisterPatient();
        tc3PatientPage.createNewPatientFunctionality(firstName, lastName, gender,birthDay,
                birthMonth, birthYear, address, city, state, county, zipCode, phone, id);
        tc3HomePage.selectHome();
    }
}

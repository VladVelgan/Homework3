package com.test.homework3.testCase2.tests;

import Utils.ConfigReader;
import com.test.homework3.testCase2.pages.TC2HomePage;
import com.test.homework3.testCase2.pages.TC2LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC2HomeTest extends TC2TestBase {

    @Parameters({"expectedHeader", "changedHeader"})
    @Test
    public void validateLocationFunctionality(String expectedHeader, String changedHeader) throws InterruptedException {
        TC2LoginPage loginPage = new TC2LoginPage(driver);
        TC2HomePage homePage = new TC2HomePage(driver);
        loginPage.loginFunctionality(ConfigReader.readProperty("QA_TC2_username"),
                ConfigReader.readProperty("QA_TC2_password"));
        homePage.loginValidation(expectedHeader);
        homePage.changeLocationValidation(changedHeader);
    }
}

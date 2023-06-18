package com.test.homework3.testCase1.tests;

import Utils.ConfigReader;
import com.test.homework3.testCase1.pages.TC1HomePage;
import com.test.homework3.testCase1.pages.TC1LoginPage;
import org.testng.annotations.Test;

public class TC1LoginTest extends TC1TestBase {

    @Test
    public void newUserCreatedFunctionalityValidation() throws InterruptedException {
        TC1LoginPage loginPage = new TC1LoginPage(driver);
        TC1HomePage homePage = new TC1HomePage(driver);
        loginPage.registerFunctionality(ConfigReader.readProperty("QA_TC1_username"), ConfigReader.readProperty("QA_TC1_password"));
        loginPage.loginFunctionality(ConfigReader.readProperty("QA_TC1_username"), ConfigReader.readProperty("QA_TC1_password"),
                ConfigReader.readProperty("QA_TC1_username"));
    }


}

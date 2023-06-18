package com.test.homework3.testCase1.tests;

import Utils.ConfigReader;
import com.test.homework3.testCase1.pages.TC1CartPage;
import com.test.homework3.testCase1.pages.TC1HomePage;
import com.test.homework3.testCase1.pages.TC1LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC1CartTest extends TC1TestBase {

    @Parameters({"pfizerVaccine", "sputnikVaccine"})
    @Test
    public void addToCartFunctionalityValidation(String pfizerVaccine, String sputnikVaccine) throws InterruptedException {
        TC1LoginPage loginPage = new TC1LoginPage(driver);
        TC1HomePage homePage = new TC1HomePage(driver);
        TC1CartPage cartPage = new TC1CartPage(driver);
        loginPage.loginFunctionality(ConfigReader.readProperty("QA_TC1_username"), ConfigReader.readProperty("QA_TC1_password"),
                ConfigReader.readProperty("QA_TC1_username"));
        homePage.addToCartFunctionality(driver, pfizerVaccine, sputnikVaccine);
        homePage.goToCartPage(driver);
        cartPage.cartItemsValidation(pfizerVaccine, sputnikVaccine);

    }


}

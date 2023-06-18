package com.test.homework3.testCase1.tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TC1TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("QA_TC1_url"));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver, "TC1Pictures");
        }
        driver.quit();
    }
}

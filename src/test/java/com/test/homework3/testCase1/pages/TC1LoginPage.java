package com.test.homework3.testCase1.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TC1LoginPage {

    public TC1LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[.='Register']")
    WebElement registerButton;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'VladVelgan')]")
    WebElement userTitle;

    public void registerFunctionality(String myUserName, String myPassword) throws InterruptedException {
        userName.clear();
        password.clear();
        registerButton.click();
        userName.sendKeys(myUserName);
        password.sendKeys(myPassword);
        registerButton.click();
        Thread.sleep(1000);
    }

    public void loginFunctionality(String myUserName, String myPassword, String expectedUser) throws InterruptedException {
        userName.clear();
        userName.sendKeys(myUserName);
        password.clear();
        password.sendKeys(myPassword);
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(userTitle), expectedUser);
    }


}

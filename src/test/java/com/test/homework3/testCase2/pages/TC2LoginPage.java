package com.test.homework3.testCase2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC2LoginPage {

    public TC2LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passWord;

    @FindBy(css = "#Laboratory")
    WebElement laboratoryButton;

    @FindBy(css = "#loginButton")
    WebElement loginButton;

    public void loginFunctionality(String username, String password) throws InterruptedException {
        userName.sendKeys(username);
        passWord.sendKeys(password);
        laboratoryButton.click();
        loginButton.click();
        Thread.sleep(500);
    }



}

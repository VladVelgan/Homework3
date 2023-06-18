package com.test.homework3.testCase1.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class TC1CartPage {

    public TC1CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//td[2]")
    List<WebElement> allCartItems;

    public void cartItemsValidation(String pfizer, String sputnik) throws InterruptedException {
        Thread.sleep(1000);
        for(WebElement item : allCartItems){
            Assert.assertTrue(BrowserUtils.getText(item).toLowerCase().contains(pfizer) ||
                    BrowserUtils.getText(item).toLowerCase().contains(sputnik));
        }

    }


}

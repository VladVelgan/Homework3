package com.test.homework3.testCase1.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TC1HomePage {

    public TC1HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy (tagName = "h5")
    List<WebElement> allItems;

    @FindBy (css = ".btn-primary")
    List<WebElement> allAddToCartButtons; // +1 in loop

    @FindBy(linkText = "Cart")
    WebElement cart;

    public  void addToCartFunctionality(WebDriver driver, String pfizer, String sputnik) throws InterruptedException {
        Thread.sleep(1000);
        for(int i = 0; i < allItems.size(); i++){
            BrowserUtils.scrollWithJS(driver, allItems.get(i));
            if(BrowserUtils.getText(allItems.get(i)).toLowerCase().contains(pfizer) ||
                    BrowserUtils.getText(allItems.get(i)).toLowerCase().contains(sputnik)){
                BrowserUtils.scrollWithJS(driver, allAddToCartButtons.get(i));
                Thread.sleep(200);
                allAddToCartButtons.get(i+1).click();
            }
        }
    }

    public void goToCartPage(WebDriver driver) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver, cart);
        Thread.sleep(1000);
        cart.click();
        Thread.sleep(1000);
    }
}

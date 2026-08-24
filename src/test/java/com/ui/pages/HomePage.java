package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[@class='login']");


    public HomePage(Browser browserName) {
        super(browserName); // To call the parent constructor we use super key word
        goToWebsite("https://automationpractice.techwithjatin.com/");
    }

    public LoginPage goToLoginPage(){
        clickOn(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}

package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']");
    private static final By SINGN_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String userName, String password){
        enterText(EMAIL_TEXT_BOX_LOCATOR,userName);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SINGN_BUTTON_LOCATOR);
        return new MyAccountPage(getDriver());

    }
}

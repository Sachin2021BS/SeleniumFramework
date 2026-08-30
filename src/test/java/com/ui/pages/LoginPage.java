package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']");
    private static final By SINGN_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");

    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert alert-danger')]/ol/li");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String userName, String password){
        enterText(EMAIL_TEXT_BOX_LOCATOR,userName);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SINGN_BUTTON_LOCATOR);
        return new MyAccountPage(getDriver());

    }

    public LoginPage doLoginWithInvlaidCredentials(String userName, String password){
        enterText(EMAIL_TEXT_BOX_LOCATOR, userName);
        enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOn(SINGN_BUTTON_LOCATOR);
        return new LoginPage(getDriver());
    }

    public String getErrorMessage(){
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }
}

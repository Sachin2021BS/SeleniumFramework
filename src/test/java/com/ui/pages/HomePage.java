package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[@class='login']");


    public HomePage(Browser browserName) {
        super(browserName); // To call the parent constructor we use super key word
        goToWebsite(readProperty(QA, "URL"));
        maximizeWindow();
    }

    public LoginPage goToLoginPage(){
        clickOn(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}

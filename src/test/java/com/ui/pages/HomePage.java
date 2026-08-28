package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;

import com.constants.Env;
import com.ui.pojo.Environment;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

import com.utility.Jsonutility;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[@class='login']");


    public HomePage(Browser browserName,boolean isHeadless) {
        super(browserName,isHeadless); // To call the parent constructor we use super key word
        //goToWebsite(readProperty(QA, "URL")); // This is for Property File
        goToWebsite(Jsonutility.readJsonFile(QA).getUrl()); // This is for JSON File
        maximizeWindow();
    }

    public LoginPage goToLoginPage(){
        clickOn(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}

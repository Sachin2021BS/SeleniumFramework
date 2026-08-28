package com.ui.tests;

import com.ui.pages.HomePage;

import com.utility.BrowserUtility;
import com.utility.Loggerutility;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.BeforeMethod;

import static com.constants.Browser.CHROME;

public class TestBase {

    protected HomePage homePage;
    Logger logger  = Loggerutility.getLogger(this.getClass());


    @BeforeMethod(description = "Load the homepageof the website")
    public void setup(){
        homePage = new HomePage(CHROME, true);
    }

    public BrowserUtility getInstance(){
        return homePage;
    }
}

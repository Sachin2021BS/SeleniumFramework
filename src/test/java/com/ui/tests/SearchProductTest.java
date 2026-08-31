package com.ui.tests;

import com.ui.pages.MyAccountPage;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{

    MyAccountPage myAccountPage;

    @BeforeMethod(description = "Valid user logs into the application")
    public void setup(){
        myAccountPage =homePage.goToLoginPage().doLoginWith("varoteb142@ebflyai.com","Password");
    }

    @Test(description = "Verify if the logged in user is able to search for a product and correct products search results are displayed",
    groups = {"e2e", "sanity"})
    public void verifyproductSearchTest(){
        myAccountPage.searchForProduct("Printed Summer Dress").getAllDressesName();
    }
}

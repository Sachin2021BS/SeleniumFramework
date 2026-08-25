package com.ui.tests;


import com.ui.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

public class LoginTest {
    HomePage homePage;

    @BeforeMethod(description = "Load the homepageof the website")
    public void setup(){
        homePage = new HomePage(CHROME);
    }


    @Test(description = "Verify if a valid user is able to login into the application", groups = {"e2e", "sanity"})
    public void loginTest() {
        assertEquals(homePage.goToLoginPage().doLoginWith("varoteb142@ebflyai.com", "Password").getUserName(),"Sachin B S" );
    }
}

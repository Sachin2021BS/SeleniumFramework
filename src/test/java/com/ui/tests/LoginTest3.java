package com.ui.tests;


import static com.constants.Browser.CHROME;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest3 {
    HomePage homePage;

    @BeforeMethod(description = "Load the homepageof the website")
    public void setup(){
        homePage = new HomePage(CHROME);
    }


    @Test(description = "Verify if a valid user is able to login into the application", groups = {"e2e", "sanity"})
    public void loginTest() {
        String userName =homePage.goToLoginPage().doLoginWith("varoteb142@ebflyai.com", "Password").getUserName();
        assertEquals(userName,"Sachin B S" );
    }
}

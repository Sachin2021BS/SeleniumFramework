package com.ui.tests;


import com.ui.pojo.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{

    @Test(description = "Verify if a valid user is able to login into the application", groups = {"e2e", "sanity"},
     dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Sachin B S" );
    }

//    @Test(description = "Verify if a valid user is able to login into the application", groups = {"e2e", "sanity"},
//            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider",
//    retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//    public void loginCSVTest(User user) {
//        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Sachin B S" );
//    }
//
//    @Test(description = "Verify if a valid user is able to login into the application", groups = {"e2e", "sanity"},
//            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginExcelDataProvider")
//    public void loginExcelTest(User user) {
//        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Sachin B S" );
//    }

    @Test(description = "Verify if the proper error message is shown for the user when they eneter invalid Credentails", groups = {"e2e", "sanity"},
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void inValidCredsLoginTest(){
        assertEquals(homePage.goToLoginPage().doLoginWithInvlaidCredentials("Test@gmail.com", "Test@1234").getErrorMessage(),
                "Authentication failed.");
    }
}

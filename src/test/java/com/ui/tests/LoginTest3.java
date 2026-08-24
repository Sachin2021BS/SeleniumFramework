package com.ui.tests;


import static com.constants.Browser.CHROME;
import com.ui.pages.HomePage;

public class LoginTest3 {
    static void main(String[] args) {
        HomePage homePage = new HomePage(CHROME);
        String userName =homePage.goToLoginPage().doLoginWith("varoteb142@ebflyai.com", "Password").getUserName();
        System.out.println(userName);
    }
}

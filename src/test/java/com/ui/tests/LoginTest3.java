package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest3 {
    static void main(String[] args) {
        //Launch a browser  and Browser session is created!!
        WebDriver wd = new ChromeDriver();
        HomePage homePage = new HomePage(wd);
        String userName =homePage.goToLoginPage().doLoginWith("varoteb142@ebflyai.com", "Password").getUserName();
        System.out.println(userName);
    }
}

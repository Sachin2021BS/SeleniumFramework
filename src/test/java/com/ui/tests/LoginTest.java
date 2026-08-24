package com.ui.tests;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    static void main(String[] args) {
        //Launch a browser  and Browser session is created!!
        WebDriver wd = new ChromeDriver();

//        BrowserUtility browserUtility = new BrowserUtility(wd);
//        browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
//        browserUtility.maximizeWindow();
//
//        By signInLinkLocator=By.xpath("//a[@class='login']");
//        browserUtility.clickOn(signInLinkLocator);
//
//        By emailTextBoxLocator = By.xpath("//input[@id='email']");
//        browserUtility.enterText(emailTextBoxLocator,"varoteb142@ebflyai.com");
//
//        By passwordTextBoxLocator = By.xpath("//input[@id='passwd']");
//        browserUtility.enterText(passwordTextBoxLocator,"Password");
//
//        By signButtonLocator = By.xpath("//button[@id='SubmitLogin']");
//        browserUtility.clickOn(signButtonLocator);
//        //wd.quit();
    }
}

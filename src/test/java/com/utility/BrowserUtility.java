package com.utility;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BrowserUtility {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BrowserUtility(WebDriver driver) {
        this.driver = driver; // initialize the instance variable driver
    }

    public BrowserUtility(Browser browserName){
        if (browserName == Browser.CHROME){
            driver = new ChromeDriver();
        } else if (browserName == Browser.EDGE) {
            driver = new EdgeDriver();
        } else if (browserName == Browser.FIREFOX) {
           driver = new FirefoxDriver();
        } else {
            System.err.println("Please select Vaild browserName like Chrome or Edge... ");
        }
    }

    public void goToWebsite(String url){
        driver.get(url);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void clickOn(By locator){
        WebElement element=driver.findElement(locator);
        element.click();
    }

    public void enterText(By locator,String textToEnter){
        WebElement element = driver.findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated( locator));
        return element.getText();
    }
}

package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public  WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver); // initialize the instance variable driver
    }

    public BrowserUtility(Browser browserName){
        if (browserName == Browser.CHROME){
            driver.set(new ChromeDriver());
        } else if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
        } else if (browserName == Browser.FIREFOX) {
           driver .set(new FirefoxDriver());
        } else {
            System.err.println("Please select Vaild browserName like Chrome or Edge... ");
        }
    }

    public void goToWebsite(String url){
        driver.get().get(url);
    }

    public void maximizeWindow(){
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator){
        WebElement element=driver.get().findElement(locator);
        element.click();
    }

    public void enterText(By locator,String textToEnter){
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated( locator));
        return element.getText();
    }

    public String takeScreenShot(String name){
        TakesScreenshot screenshot = (TakesScreenshot)driver.get();
        File ScreenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String timeStamp = formatter.format(date);
        String path = System.getProperty("user.dir")+"\\screenshots\\"+name + "" +timeStamp+".png";
        File ScreenshotFile = new File(path);
        try {
            FileUtils.copyFile(ScreenshotData, ScreenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}

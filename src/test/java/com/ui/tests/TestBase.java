package com.ui.tests;

import com.ui.pages.HomePage;

import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.Loggerutility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import static com.constants.Browser.CHROME;

public class TestBase {

    protected HomePage homePage;
    Logger logger  = Loggerutility.getLogger(this.getClass());
    private boolean isLambdaTest = true;
    private boolean isHeadless = true;

    @BeforeMethod(description = "Load the homepageof the website")
    public void setup(ITestResult result) throws MalformedURLException {
        WebDriver lambdaDriver = null;
        if(isLambdaTest){
            LambdaTestUtility.intilaizeLambdaTestSession("chrome", result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
            
        } else {
            //Running the test on local Machine !!
            logger.info("Loading the homepageof the website");
            homePage = new HomePage(CHROME, true);
        }
    }

    public BrowserUtility getInstance(){
        return homePage;
    }

    @AfterMethod(description = "Tear Down the browser")
    public void tearDown()  {
        if(isLambdaTest){
            LambdaTestUtility.quitSession(); // Quit or close the browsersession on Lambda Test
        } else {
            homePage.quit(); // quit local session
        }
    }
}

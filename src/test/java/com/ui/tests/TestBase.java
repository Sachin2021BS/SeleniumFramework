package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;

import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.Loggerutility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {

    protected HomePage homePage;
    Logger logger  = Loggerutility.getLogger(this.getClass());
    private boolean isLambdaTest;

    @Parameters({"browser", "isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "Load the homepageof the website")
    public void setup(@Optional("chrome") String browser,
                      @Optional("false") boolean isLambdaTest,
                      @Optional("false") boolean isHeadless , ITestResult result)  {
        this.isLambdaTest = isLambdaTest;
        WebDriver lambdaDriver = null;
        if(isLambdaTest){
            LambdaTestUtility.intilaizeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
            
        } else {
            //Running the test on local Machine !!
            logger.info("Loading the homepageof the website");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
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

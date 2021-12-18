package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadconfig() throws IOException
	{
		prop=new Properties();
		String filepath=System.getProperty("User.dir")+"\\Configurations\\config.properties";
		FileInputStream fis=new FileInputStream(filepath);
		prop.load(fis);
	}
	
	
	@AfterTest
	public void launchBrowser()
	{
		
		String browserName=prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		}
		else if (browserName.contains("Firefox")) {
			driver=new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}else if (browserName.contains("Edge")) {
			driver=new EdgeDriver();
			WebDriverManager.edgedriver().setup();
		}
		
	}
}


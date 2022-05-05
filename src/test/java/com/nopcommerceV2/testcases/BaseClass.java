package com.nopcommerceV2.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerceV2.utilities.ReadConfig;

public class BaseClass {

	
	ReadConfig con = new ReadConfig();
	
	
	
	public String baseurl = con.GetApplicationUrl();
	public String username = con.GetUsername();
	public String password = con.GetPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("Browser")
	public void Setup(String br) {
		
		
		logger = Logger.getLogger("nopcommerceV2");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if(br.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", con.GetChromePath());
		driver = new ChromeDriver();
		}
		
		else if(br.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", con.GetFirfoxPath());
			driver = new FirefoxDriver();
			
		}
	
	}
	
	@AfterClass
	public void Teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
  }
}


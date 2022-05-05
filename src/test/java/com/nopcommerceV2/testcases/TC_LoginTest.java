package com.nopcommerceV2.testcases;

import java.io.IOException;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.nopcommerceV2.pageObjects.LoginPage;



public class TC_LoginTest extends BaseClass {


	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		driver.get(baseurl);
		logger.info("url is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.SetUserName(username);
		lp.SetPassword(password);
		
		lp.ClickLogin();
		Thread.sleep(15000);
		//String ActualTitle = driver.getTitle();
		//System.out.println(ActualTitle);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			
			Assert.assertTrue(true);
			lp.ClickLogout();
			logger.info("Login Test passed");
		}
		else {
			
		    captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
		
		
	}
	
}
	


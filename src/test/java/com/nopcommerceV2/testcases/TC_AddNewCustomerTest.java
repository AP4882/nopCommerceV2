package com.nopcommerceV2.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerceV2.pageObjects.AddNewCustomer;
import com.nopcommerceV2.pageObjects.LoginPage;

public class TC_AddNewCustomerTest extends BaseClass {

	@Test
	public void AddCustomer() throws InterruptedException, IOException {
		
		driver.get(baseurl);
		LoginPage lp=new LoginPage(driver);
		lp.SetUserName(username);
		lp.SetPassword(password);
		
		lp.ClickLogin();
		Thread.sleep(3000);
		
   AddNewCustomer addcust=new AddNewCustomer(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
				
		addcust.setPassword("test123");
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addcust.setCustomerRoles("Guest");
		
		addcust.setManagerOfVendor("Vendor 2");
		
		addcust.setGender("Male");
		
		addcust.setFirstName("Pavan");
		addcust.setLastName("Kumar");
		
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
	
		addcust.clickOnSave();
		
		logger.info("validation started....");
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
				
	}
	
	
	
	public static String randomestring() {
		
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
	
	

	}


package com.nopcommerceV2.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy (xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement btnLogin;
	
	@FindBy(linkText= "Logout")
	WebElement btnLogout;
	
	public void SetUserName(String uname) throws InterruptedException {
		
		txtEmail.clear();
		Thread.sleep(3000);
		txtEmail.sendKeys(uname);
		Thread.sleep(4000);
		
	}
	
    public void SetPassword(String Password) throws InterruptedException {
		
    	txtPassword.clear();
    	Thread.sleep(2000);
		txtPassword.sendKeys(Password);
		
	}
	
	public void ClickLogin() {
		btnLogin.click();
		
	}
 
	public void ClickLogout() {
		btnLogout.click();
		
	}
}

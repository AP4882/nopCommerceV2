package com.nopcommerceV2.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerceV2.pageObjects.LoginPage;
import com.nopcommerceV2.utilities.XLUtils;





public class TC_LoginDDT extends BaseClass {
	
	
@Test(dataProvider="LoginData")
public void LoginTest(String Uname, String pwd) throws InterruptedException, IOException {
	
	driver.get(baseurl);
	logger.info("url is opened");
	
	LoginPage lp=new LoginPage(driver);
	lp.SetUserName(Uname);
	lp.SetPassword(pwd);
	
	lp.ClickLogin();
	Thread.sleep(5000);
	//String ActualTitle = driver.getTitle();
	//System.out.println(ActualTitle);
	
	if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
		
		Assert.assertTrue(true);
		lp.ClickLogout();
		logger.info("Login Test passed");
	}
	else {
		
	  //  captureScreen(driver, "Login_DDT_Test");
		Assert.assertTrue(false);
		logger.info("Login Test failed");
	}
	
		
}



@DataProvider(name="LoginData")	
public String[][] GetData() throws IOException{
	
	String Path="C:/Users/Ashish Pabitwar/eclipse-workspace1/nopcommerceV2/src/test/java/com/nopcommerce/Testdata/LoginData.xlsx";
	
	
	int rownum= XLUtils.getRowCount(Path, "sheet1");
	int ColCount= XLUtils.getCellCount(Path, "sheet1", 1);
	
	String logindata[][]= new String[rownum][ColCount];
	
	for(int i=1;i<=rownum;i++) {
		for(int j=0;j<ColCount;j++) {
			
			logindata[i-1][j]= XLUtils.getCellData(Path, "sheet1", i, j);
			
		}
		
	}
	return logindata;
}

	
	
}


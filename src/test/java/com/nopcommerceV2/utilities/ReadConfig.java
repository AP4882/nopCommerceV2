package com.nopcommerceV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;

public ReadConfig() {
	
	File src = new File("./Configuration/config.properties");
	
	try {
		
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	} catch(Exception e) {
		System.out.println("Exception is:"+e.getMessage());
	}
}
	
public String GetApplicationUrl() {
	String url = pro.getProperty("baseurl");
	return url;
	
}
public String GetUsername() {
	String Uname = pro.getProperty("username");
	return Uname;
}
public String GetPassword() {
	String Password = pro.getProperty("password");
	return Password;
}

public String GetChromePath() {
	String Chromepath = pro.getProperty("chromepath");
	return Chromepath;
}

public String GetFirfoxPath() {
	String Firefoxpath = pro.getProperty("Firefoxpath");
	return Firefoxpath;
}

}

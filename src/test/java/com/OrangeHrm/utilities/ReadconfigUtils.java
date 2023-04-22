package com.OrangeHrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadconfigUtils {
	Properties pro;

	public ReadconfigUtils() 
	{
     File src= new File("./Configuration/config.properties");
	 try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	} catch (Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}
	}
	public String getApplicationURL() 
	{
		String url = pro.getProperty("baseURL");
	    return url;
	}
	public String getApplicationPassword() 
	{
		String password = pro.getProperty("passWord");
	    return password;
	}
	public String getApplicationUserName() 
	{
		String username = pro.getProperty("userName");
	    return username;
	}
}

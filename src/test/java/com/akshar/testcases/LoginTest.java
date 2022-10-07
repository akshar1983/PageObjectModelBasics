package com.akshar.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.akshar.pages.HomePage;
import com.akshar.pages.LoginPage;
import com.akshar.pages.ZohoAppPage;
import com.akshar.utilities.Utilities;

public class LoginTest extends BaseClass{
	
	
	@Test(dataProviderClass= Utilities.class, dataProvider = "dp")
	public void LoginTest(Hashtable<String, String> data) {
		
		HomePage home = new HomePage();
		LoginPage lp = home.SignIn();
		ZohoAppPage zp = lp.doLogin(data.get("username"), data.get("password"));
		//ZohoAppPage zp = lp.doLogin("akshar_mysore@rediffmail.com","Smithajain1");
		
		//Assert.fail("Login test failed");
		
		
	}

}

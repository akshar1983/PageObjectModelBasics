package com.akshar.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.akshar.base.Page;
import com.akshar.pages.ZohoAppPage;
import com.akshar.pages.crm.accounts.AccountsPage;
import com.akshar.pages.crm.accounts.CreateAccountPage;
import com.akshar.utilities.Utilities;


public class CreateAccountTest {
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) 
	
	{
		ZohoAppPage zp = new ZohoAppPage();
		zp.gotoCRM();
		AccountsPage ap  = Page.menu.goToAccount();

		CreateAccountPage cap = ap.goToCreateAccount();
		cap.CreateAccount(data.get("accountname"));
	}

}

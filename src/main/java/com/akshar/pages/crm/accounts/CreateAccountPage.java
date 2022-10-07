package com.akshar.pages.crm.accounts;

import org.openqa.selenium.By;

import com.akshar.base.Page;

public class CreateAccountPage extends Page {
	
	public void  CreateAccount(String accountName) {
		
		//menu.signOut();
		
		//driver.findElement(By.xpath("//input[@id='Crm_Accounts_ACCOUNTNAME_LInput']")).sendKeys(accountName);
		
		type("AccountName_XPATH",accountName);
	}

}

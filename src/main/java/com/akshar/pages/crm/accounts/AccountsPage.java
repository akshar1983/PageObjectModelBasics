package com.akshar.pages.crm.accounts;

import org.openqa.selenium.By;

import com.akshar.base.Page;

public class AccountsPage extends Page{
	
	
	
public CreateAccountPage goToCreateAccount() {
	
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//driver.findElement(By.xpath("//button[@data-zcqa = 'cv_createbtn']")).click();
	
	click("CreateAccount_XPATH");

	return new  CreateAccountPage();
		
	}
	

}

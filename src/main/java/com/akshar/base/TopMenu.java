package com.akshar.base;

import org.openqa.selenium.By;

import com.akshar.pages.crm.accounts.AccountsPage;

/*Home page has a Top Menu
Accounts page has a Top Menu
*/


public class TopMenu {
	
	public void goToHome() {}
	
	public void goToLeads() {}
	
	public void goToContacts() {}
	
	public AccountsPage goToAccount() {
		
		//Page.driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		Page.click("AccountsTab_XPATH");
		return new AccountsPage();
	}
	
	public void goToDeals() {}
	
	public void goToTasks() {}
	
	public void signOut() {}

}

package com.akshar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.akshar.base.Page;
import com.akshar.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page{
	
	/*
	 * WebDriver driver;
	 * 
	 * public ZohoAppPage(WebDriver driver) {
	 * 
	 * this.driver = driver; }
	 */


	public void gotoCliq() {
		
		driver.findElement(By.xpath("//div[text()='Cliq']")).click();
		
	}
	
	
public CRMHomePage gotoCRM() {
		
	
		
	click("CRMLink_XPATH");
	
	return new CRMHomePage();
		
	}

public void gotoCampaigns() {
	
	driver.findElement(By.xpath("//div[text()='Campaigns']")).click();
	
	
}
}

package com.akshar.pages;

import org.openqa.selenium.By;

import com.akshar.base.Page;

public class LoginPage extends Page {
	
	/* 
	 * WebDriver driver;
	 * 
	 * public LoginPage(WebDriver driver) { this.driver = driver; }
	 */
	
	public ZohoAppPage doLogin(String username,String password)
	{
		System.out.println(username);
		System.out.println(password);
	
		//driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys(username);
		
		type("Username_XPATH",username);
		
		//driver.findElement(By.xpath("(//button[@id='nextbtn'])[1]")).click();
		click("Nextbtn_XPATH");
		
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		type("Password_XPATH",password);
		
		//driver.findElement(By.xpath("(//span[text()='Sign in'])[2]")).click();
		click("SignIn_XPATH");
		return new ZohoAppPage();
		
	}
	
	public void Sales() {}
	
	public void goToFinance() {}

}

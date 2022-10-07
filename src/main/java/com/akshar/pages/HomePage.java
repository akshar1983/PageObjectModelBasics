package com.akshar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.akshar.base.Page;

public class HomePage extends Page

{
	
	
	/*
	 * WebDriver driver;
	 * 
	 * public HomePage(WebDriver driver) { this.driver = driver; }
	 */
	



public LoginPage SignIn() {
		
		//driver.findElement(By.xpath("//a[@class='zh-login']")).click();
	
	click("SignInLink_XPATH");
		
		return new LoginPage();
	}

	
	public void Support() {
		
		//driver.findElement(By.xpath("//a[@class='zh-support']")).click();
		click("SupportLink_XPATH");
		
	}
	
	public void FreeSignUp() {
		
		//driver.findElement(By.xpath("//a[@class='zh-signup']")).click();
		click("FreeSignUp_XPATH");
	}
	
	public void Customers() {
		
		//driver.findElement(By.xpath("//a[@class='zh-customers']")).click();
		click("Customers_XPATH");
	}
	
	public void LearnMore() {
		
		//driver.findElement(By.xpath("//a[@class='learn-more']")).click();
		click("LearnMoreLink_XPATH");
		
	}
	
	public void ValidateFooterLinks()

		{
		}
		
}


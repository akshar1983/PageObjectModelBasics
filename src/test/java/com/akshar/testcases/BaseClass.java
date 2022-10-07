package com.akshar.testcases;

import org.testng.annotations.AfterSuite;

import com.akshar.base.Page;

public class BaseClass {
	
	
	@AfterSuite
	public void tearDown() {
		
		Page.quit();
		
	}

}

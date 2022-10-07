
package com.akshar.listeners;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.akshar.base.Page;
import com.akshar.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener,ISuiteListener {
	
	public void onTestFail(ITestResult arg0)
	{
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	try {
		Utilities.captureScreenshot();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Reporter.log("Capturing screenshot");
	Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
	Reporter.log("<br>");
	Reporter.log("<br>");
	Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+"height=200 width=200></img></a>");
 

	}
	
	public void onTestStart(ITestResult arg0)
	
	{
		
		
		if(Utilities.isTestRunnable(arg0.getName(),Utilities.excel))
			
		{
			throw new SkipException("Skipping the test"+arg0.getName().toUpperCase()+" as the runmode is No");
		}
	}
}

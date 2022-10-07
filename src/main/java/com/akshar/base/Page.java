
package com.akshar.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.akshar.utilities.ExcelReader;
import com.akshar.utilities.ExtentManager;
import com.akshar.utilities.Utilities;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	public static WebDriver driver;
	private static Properties or = new Properties();
	private static Properties config = new Properties();
	private static FileInputStream fis;
	public static Logger log = Logger.getLogger(Page.class);
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\akshar\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports extent;
	public static ExtentTest test;
	public static String browser;
	public static TopMenu menu;
	public ExtentSparkReporter htmlReporter;
	
	//public ExtentTest test1;
		
	public Page()
	
	{
		if(driver==null) {
			
			
			try {
				fis = new FileInputStream(".//src//test//resources//com//akshar//properties//Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config file is loaded");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream(".//src//test//resources//com//akshar//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				or.load(fis);
				log.info("OR file is loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Jenkins system Browser
			
			if(System.getenv("browser")!= null && !System.getenv("browser").isEmpty()) 
			{ 
				browser = System.getenv("browser");
				
			}
					else 
					{
						browser = config.getProperty("browser");
					}
				config.setProperty("browser", browser);
			
		
		if(config.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			System.out.println("Chrome browser is launched");
			log.info("Chrome browser is launched");
			Map<String,Object> prefs = new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs",prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
		}else if(config.getProperty("browser").equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser is launched");
			}	
		
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to the testsite url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait = new WebDriverWait(driver,(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait")))));
		menu = new TopMenu();
		}
}
	
	public static void quit()  {
		
		driver.quit();
	}
	
	//Common Keywords
public static void click(String locator)
	
	{
	
	System.out.println(locator);
	if(locator.endsWith("_CSS"))
	
	{
	driver.findElement(By.cssSelector(or.getProperty(locator))).click();
	} else if(locator.endsWith("_XPATH"))
	{
		driver.findElement(By.xpath(or.getProperty(locator))).click();

	}else if(locator.endsWith("_ID"))
	{
		driver.findElement(By.id(or.getProperty(locator))).click();

	}
	//test = extent.createTest("Click Functionality");
	//test.info("Click");
	
	}
	
	public static void type(String locator,String value)
	
	{
		
		if(locator.endsWith("_CSS"))
		
		{
			System.out.println("Testing Type");
			System.out.println(or.getProperty(locator));
		driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
		
		}else if(locator.endsWith("_XPATH")){
			
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
			
		}else if(locator.endsWith("_ID")){
			
			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
			
		}
		
		//test.log(Status.INFO, "Typing in"+locator+"Entered value is"+value);
	}
	
	static WebElement dropdown;
	
	public static void select(String locator,String value)
	
	{
		System.out.println(locator);
		System.out.println(or.getProperty(locator));
		System.out.println(value);
		if(locator.endsWith("_CSS"))
		
		{
		dropdown = driver.findElement(By.cssSelector(or.getProperty(locator)));
		System.out.println(driver.findElement(By.cssSelector(or.getProperty(locator))));
		System.out.println("Post if condition");

		}else if(locator.endsWith("_XPATH")){
			
			dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
			
		}else if(locator.endsWith("_ID")){
			
			dropdown = driver.findElement(By.id(or.getProperty(locator)));
			
		}
		
		System.out.println(driver.findElement(By.cssSelector(or.getProperty(locator))));
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		//test.log(Status.INFO, "Selecting the value in "+locator+"Entered value is"+value);
		
	}
	
	public boolean isElementPresent(By by) {
	try{
		driver.findElement(by);
		return true;
	}catch(NoSuchElementException e) {
		return false;
	}
	}
	
	public static void verifyEquals(String expected,String actual) throws IOException
	{
		try {
			
			Assert.assertEquals(actual, expected);
			
		}catch(Throwable t)
		{
			Utilities.captureScreenshot();
			//ReportNG
			Reporter.log("<br>"+"Verification failure : "+t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+"height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			
			//test.log(Status.FAIL, test.(Utilities.screenshotName+"height=200 width=200></img></a>"));
		}
	}

}

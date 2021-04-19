package com.nagarro.nagpsession;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethod{
	protected static WebDriver driver;
	protected String url,browser,email,passwd;
	protected static Properties prop ;
	//launching browser  
	public static void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//Setting webdriver.chrome.driver property  
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");  
			//Instantiating driver object and launching browser  
			driver = new ChromeDriver();  
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");        
	        driver= new FirefoxDriver();
		}
	}
	public static void readProperty()
	{
		try
		{
			prop = new Properties();
		    FileInputStream reader=new FileInputStream(".\\config\\data.Properties");   
			prop.load(reader);  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void browserClose()
	{
		//Closing the browser  
		driver.quit();  
	}
	public static void openUrl(String url)
	{
		//Using get() method to open a webpage  
		driver.get(url);  
	}
}

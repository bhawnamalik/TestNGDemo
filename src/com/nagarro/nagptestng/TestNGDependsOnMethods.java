package com.nagarro.nagptestng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nagarro.nagpsession.CommonMethod;
import com.nagarro.nagpsession.login;

public class TestNGDependsOnMethods extends CommonMethod{
	
	@BeforeTest
	public void readProperties()
	{
		CommonMethod.readProperty();
		url = prop.getProperty("url");
		browser = prop.getProperty("browser");
		email = prop.getProperty("email");
		passwd = prop.getProperty("password");
	}
	@Test
	public void startSession()
	{
		CommonMethod.launchBrowser(browser);
		CommonMethod.openUrl(url);
	}
	@Test(dependsOnMethods={"startSession"})
	public void loginTest()
	{
		login.login(email, passwd);
		String expectedTitle = "My account - My Store";
		String actualTile = driver.getTitle();
		Assert.assertEquals(actualTile, expectedTitle);
	}
	@Test(dependsOnMethods= {"loginTest"})
	public void logoutTest()
	{
		login.logout();
		String expectedTitle = "My Store";
		String actualTile = driver.getTitle();
		Assert.assertEquals(actualTile, expectedTitle, "Tille is not as expected");
		
	}

	@Parameters({"browser"})
	@Test
	public void verifyParameter(@Optional("chrome") String browser)
	{
		System.out.println("parameter "+ browser);
	}
	@Test(dependsOnMethods={"startSession"}, alwaysRun=true)
	public void endSession()
	{
		CommonMethod.browserClose();
	}
}

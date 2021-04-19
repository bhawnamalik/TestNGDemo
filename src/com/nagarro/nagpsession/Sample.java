package com.nagarro.nagpsession;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sample extends CommonMethod{
	@BeforeTest
	public void readProperties()
	{
		CommonMethod.readProperty();
		url = prop.getProperty("url");
		browser = prop.getProperty("browser");
		email = prop.getProperty("email");
		passwd = prop.getProperty("password");
	}
	@BeforeMethod
	public void startSession()
	{
		CommonMethod.launchBrowser(browser);
		CommonMethod.openUrl(url);
	}
	@Test
	public void loginTest()
	{
		login.login(email, passwd);
		String expectedTitle = "My account - My Store";
		String actualTile = driver.getTitle();
		Assert.assertEquals(actualTile, expectedTitle);
	}
	@Test
	public void loginTestSoftAsset() throws Exception
	{
		login.login(email, passwd);
		Thread.sleep(5000);
		String expectedTitle = "My account - My Store";
		String actualTile = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTile, expectedTitle);
		System.out.println("After soft assert");
		softAssert.assertAll();	
	}

	@Parameters({"browser"})
	@Test
	public void verifyParameter(@Optional("chrome") String browser)
	{
		System.out.println("parameter "+ browser);
	}
	@AfterMethod
	public void endSession()
	{
		CommonMethod.browserClose();
	}
}
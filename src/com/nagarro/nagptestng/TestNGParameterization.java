package com.nagarro.nagptestng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterization {
	//Parameterization : Common data to for multiple test cases
	/*
	 * Parameterization in Selenium is a process to parameterize the test scripts in order to pass multiple data to the application at runtime.
	 * There are two ways by which we can achieve parameterization in TestNG

		With the help of Parameters annotation and TestNG XML file.
		TestNG: Parameterization using XML & DataProvider in Selenium
		With the help of DataProvider annotation.
	 */
	@Parameters({"browser"})
	@Test
	public void verifyParameter(String browser)
	{
		System.out.println("parameter : "+ browser);
	}
	@Test
	public void dummy() {
		System.out.println("dummy");
	}
}

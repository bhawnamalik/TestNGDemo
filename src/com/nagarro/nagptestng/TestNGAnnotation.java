package com.nagarro.nagptestng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("before suite");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("before test");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("before class");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("before Method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after Method");
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("after class");
	}
	@Test
	public void test1()
	{
		System.out.println("TestNGAnnotation");
	}
	@Test
	public void test2()
	{
		System.out.println("Test case 3");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("after test");
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("after suite");
	}


	public class TestNGAnnotation1{
		@Test
		public void test()
		{
			System.out.println("TestNGAnnotation1");	 
		}
	}
}
package com.nagarro.nagptestng;

import org.testng.annotations.Test;

public class TestNGGrouping {

	@Test(groups= {"G1"}) 
	public void G1T1()
	{
		System.out.println("Test case group 1 test case 1");
	}	
	@Test(groups= {"G1"}, description = "This is Group 1 test case") 
	public void G1T2()
	{
		System.out.println("Test case group 1 test case 2");
	}
	//invocationCount - how many time test case should run
	@Test(groups= {"G1"},invocationCount = 2) 
	public void G1T3()
	{
		System.out.println("Test case group 1 test case 3");
	}
	@Test(groups= {"G2"}) 
	public void G2T1()
	{
		System.out.println("Test case group 2 test case 1");
	}
	@Test(groups= {"G1,G2"}) 
	public void G2T2()
	{
		System.out.println("Test case group 2 test case 2");
	}
	@Test(groups= {"G3"}) 
	public void G3T1()
	{
		System.out.println("Test case group 3 test case 1");
	}
	@Test(groups= {"G3"}) 
	public void G3T2()
	{
		System.out.println("Test case group 3 test case 2");
	}
	@Test
	public void sample1()
	{
		System.out.println("sample 1");
	}
	//enabled = false --> Skip test case
	@Test(enabled = false) 
	public void sample2()
	{
		System.out.println("sample 2");
	}
}

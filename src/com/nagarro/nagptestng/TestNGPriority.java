package com.nagarro.nagptestng;
import org.testng.annotations.Test;

public class TestNGPriority {
	/*Default priority is zero, 
	if no priority is set then test cases will execute in alphabetical order
	*/
	@Test(priority = -1)
	public void testminus1()
	{
		System.out.println("Test priority -1");
	}
	@Test(priority = -2)
	public void testminus2()
	{
		System.out.println("Test priority -2");
	}
	@Test(priority = 1)
	public void testpriority1()
	{
		System.out.println("Test priority 1");
	}
	@Test(priority = 2)
	public void testpriority2()
	{
		System.out.println("Test priority 2");
	}
	@Test
	public void test()
	{
		System.out.println("Test case 1");
	}
	@Test(enabled = false)
	public void skipTest()
	{
		System.out.println("Test case skip");
	}

}

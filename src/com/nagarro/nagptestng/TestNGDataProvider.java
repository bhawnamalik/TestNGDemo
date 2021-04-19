package com.nagarro.nagptestng;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nagarro.nagpsession.CommonMethod;

public class TestNGDataProvider extends CommonMethod {
/*
	 *  DataProviders pass different values to the TestNG Test Case in a single execution and in the form of TestNG Annotations. It is a part of the inbuilt TestNG data-driven testing for which TestNG is quite popular
	 *  Exceute same test case with multiple data
	 *  @DataProvider (name = “name_of_dataprovider”)
		public Object[][] dpMethod() {
		return new Object [][] { values}
		}
	 */
	

    @BeforeTest
    public void setup(){
    	CommonMethod.launchBrowser("firefox");
    	CommonMethod.openUrl("https://google.com");
    }
 
    /** Test case to verify google search box
     * @param author
     * @param searchKey
     * @throws InterruptedException
     */

    @Test(dataProvider="SearchProvider")
    public void testMethod(String author,String searchKey) throws InterruptedException{
    {
        WebElement searchText = driver.findElement(By.name("q"));
        //search value in google searchbox
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        Thread.sleep(3000);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue +"::::"+searchKey);
        searchText.clear();
        //Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }
    }
    /**
     * @return Object[][] where first column contains 'author'
     * and second column contains 'searchKey'
     */

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };

    }
	
	@AfterTest
	public void closeBrowser()
	{
		CommonMethod.browserClose();
	}
	
	
	
	/* switch
 @DataProvider (name = "data-provider")
 public Object[][] dpMethod (Method m){
 switch (m.getName()) {
 case "Sum": 
 return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
 case "Diff": 
 return new Object[][] {{2, 3, -1}, {5, 7, -2}};
 }
 return null;
 
 }
 
   @Test (dataProvider = "data-provider")
     public void Sum (int a, int b, int result) {
         int sum = a + b;
         Assert.assertEquals(result, sum);
     }
   
   @Test (dataProvider = "data-provider")
     public void Diff (int a, int b, int result) {
         int diff = a - b;
         Assert.assertEquals(result, diff);
     }
     
     */
}


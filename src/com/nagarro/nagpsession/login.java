package com.nagarro.nagpsession;
import org.openqa.selenium.By;

public class login extends CommonMethod{
	public static void login(String userName, String password)
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();	
	}
	public static void logout()
	{
		driver.findElement(By.className("logout")).click();
	}
}
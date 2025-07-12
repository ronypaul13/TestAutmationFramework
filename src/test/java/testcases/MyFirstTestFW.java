package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class MyFirstTestFW extends BaseTest{

	@Test(dataProviderClass=ReadXLSData.class,dataProvider="logindata")
	public static void LoginTest(String username, String password)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText(prop.getProperty("signin_link"))).click(); //locators --> properties
		driver.findElement(By.id(prop.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(prop.getProperty("next_button"))).click();
		driver.findElement(By.id(prop.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.xpath(prop.getProperty("login_button"))).click();
	}
	
	/* @DataProvider(name = "FirstTest")
	public Object[][] testdata() {
	 return new Object[][] {
	   { "ronypauli@gmail.com", "Rony@zoho" },
	   { "ronypaulireland@gmail.com", "Ro@zoho" },
	   { "ronylireland@gmail.com", "Rony@zo" },
	   { "ronypaulireland@gmail.com", "Rony@zoho" }
	 };
	} */

}

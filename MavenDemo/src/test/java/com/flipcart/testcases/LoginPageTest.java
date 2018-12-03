package com.flipcart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.flipcart.base.FlipcartBase;
import com.flipcart.pages.HomePage;
import com.flipcart.pages.LoginPage;

public class LoginPageTest extends FlipcartBase {

	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest () {
		
		super();
		
	}
	
	
	@BeforeClass
		
    public void setUP()
    
    {
		initialization();
		 loginPage = new LoginPage();
		
		
    }
	
	
	
	@Test(priority = 1)	
	public void loginPageTitleTest()
	
	{
		String Title = loginPage.validateLoginPage();
		
		Assert.assertEquals(Title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Exclusive Offers!");
		
		}

	@Test(priority = 2)
	
	public void loginTest() throws InterruptedException
	{
		
		//Thread.sleep(2000);
		
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterClass

	public void closeBrowser()
	
	{
		
		driver.quit();
		
	}
	
}

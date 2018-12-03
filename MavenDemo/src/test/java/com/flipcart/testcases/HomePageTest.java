package com.flipcart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipcart.base.FlipcartBase;
import com.flipcart.pages.HomePage;
import com.flipcart.pages.LoginPage;
import com.flipcart.pages.MobileHomePage;



public class HomePageTest extends FlipcartBase {

	
	LoginPage loginPage;
	HomePage homepage;

	
	public HomePageTest () {
		
		super();
		
	}
	
	
	@BeforeClass
		
    public void setUP()
    
    {
		initialization();
		 loginPage = new LoginPage();
		 homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
    }
	
	@Test(priority = 1)
	
	public void VerifyUserLoginTest()
	
	{
		
		String user = homepage.validateUserLogin();
	
		String un = prop.getProperty("username");
		
		
		if (user.contains(un))
			
			System.out.println( un+ " is logged in successfully");
		
		else 
			
			System.out.println("LOGIN FAIL");
		
		
	}
	
	
	@Test(priority = 1)
	
	public void verifyTopMenuTest()
	
	{
		
	  Assert.assertTrue(homepage.vlaidatetopMenu());
	System.out.println("Electornice present in the tope menu");
	
	 
	}
	
	@Test(priority = 3)
	
	public void verifyMobilePage() throws InterruptedException
	{
		//System.out.println("In verifyMobilePage ");
		//homepage.navigateToMobilePage();
		Assert.assertEquals(homepage.navigateToMobilePage(), "Mobiles");
	}
	
	@AfterClass

	public void closeBrowser()
	
	{
	
		driver.quit();
		
	}
}

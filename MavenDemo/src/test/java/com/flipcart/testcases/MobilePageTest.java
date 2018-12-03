package com.flipcart.testcases;


import java.io.IOException;

import org.openqa.selenium.By;
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
import com.flipcart.util.TakeSnapShot;

public class MobilePageTest extends FlipcartBase {

	
	LoginPage loginPage;
	HomePage homepage;
	MobileHomePage mobilehomepage;
	TakeSnapShot takesnap;
	
	
	public MobilePageTest () {
		
		super();
		
	}
	
	
	@BeforeClass
		
    public void setUP() throws InterruptedException
    
    {
		initialization();
		 loginPage = new LoginPage();
		 homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	     homepage.addDelay();
	     //System.out.println("Now search mobile ");
	     homepage.navigateToMobilePage();
	     homepage.addDelay();
	     mobilehomepage = new MobileHomePage();
	     mobilehomepage.selectRam();
	     takesnap = new TakeSnapShot();
    }
	
		
	
	@Test(priority = 1)

	public void verfiyRamSizeOfFirstItem()
	{
		Assert.assertTrue(mobilehomepage.ValidateItemkDescriptionForRam());
	
	}
	
	@Test(priority = 2)

	public void verfiyRamSizeOfSecondItem()
	{
		Assert.assertTrue(mobilehomepage.ValidateItemkDescriptionForRamtwo());
	}
	
	@Test(priority = 3)
	
	public void verfiyBrandCheckbox() throws InterruptedException
	
	{
		mobilehomepage.searchBrand("moto");
		Assert.assertTrue(mobilehomepage.validateBrandCheckbox());
		
	}
	

	
	@Test(priority = 4)
	
	public void selecBrandTest() throws InterruptedException
	
	{
		
		mobilehomepage.selectBrand();
		
	}
	
	
	@Test(priority = 5)
	
	public void verfiyBrandNameofFirstItem() throws InterruptedException {
		
	//	mobilehomepage.selectBrand();
	    Thread.sleep(2000);
			
		Assert.assertEquals(mobilehomepage.ValidateBrandfilterforfirstitem(), "Moto G5s Plus (Blush Gold, 64 GB)");
	
		
	}
	
	@Test(priority = 6)
	
	public void verfiyBrandNameOfSecondItem()
	
	{
		
		Assert.assertEquals(mobilehomepage.ValidateBrandfilterforsecondtitem(),"Moto G5s (Oxford Blue, 32 GB)");
		
	
					
		
	}
	
	@Test(priority = 7)
	
	public void verifyClearBrandFilter()
	{
	
		mobilehomepage.clearBrandFilter();
		
	
   }

	@Test(priority = 8)
	
	public void checkNewBrandName() throws InterruptedException

	{
		
		
	String s = mobilehomepage.checkBrandNameAfterRemovingFilter();
    	
    	if(!s.contains("Moto"))
    			
    		System.out.println("Pass:- 1st item is not of moto brand");	
    			
    	else 
    		System.out.println("Fail :- 1st item is of moto brand");
		
	}
	
	
	@Test(priority = 9)
	
	
	public void verfiyMobileDescription() throws InterruptedException
	{
		
		mobilehomepage.searchBrand("moto");
		mobilehomepage.selectBrand();
		Assert.assertEquals(mobilehomepage.checkMobileDescription(), "Moto G5s (Lunar Gray, 32 GB)");
		//mobilehomepage.selectMobile()	
	}
	
	
	@Test(priority = 10)
	
	public void addMoibletoTheCart() throws InterruptedException
	
	{
		
		mobilehomepage.selectMobile();
	    String s= mobilehomepage.addToCart();
		Assert.assertEquals(s, "Moto G5s (Lunar Gray, 32 GB)");
		
	}
	
	@AfterClass
	
	public void takeScreen() throws InterruptedException, IOException
	{
		
		takesnap.takeScreenShot();
	}
	
	
}

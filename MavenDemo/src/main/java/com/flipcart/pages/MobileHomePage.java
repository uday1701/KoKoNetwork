package com.flipcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipcart.base.FlipcartBase;

public class MobileHomePage  extends FlipcartBase  {

	
	

	//Page factor =OR:
	
	@FindBy(xpath="//div[@class='_1GEhLw' and text() = '4 GB' ]")
	WebElement ram;
	
	@FindBy(xpath=".//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[3]/ul/li[1]")
	WebElement ramsizeoffirstitem;
	
	@FindBy(xpath=".//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[4]/div/div/div/a/div[3]/div[1]/div[3]/ul/li[1]")
	WebElement ramsizeofsecondtitem;
	
	@FindBy(xpath=".//*[@class='_3vKPvR']")
	WebElement brandsearchbar;
	
	@FindBy(xpath="//div[@class='_1GEhLw' and text() = 'Motorola' ]")
	WebElement selectbrand;
	
	@FindBy(xpath=".//*[text()='Moto G5s Plus (Blush Gold, 64 GB)']")
	WebElement brandnameeoffirstitem;

	@FindBy(xpath=".//*[text()='Moto G5s (Oxford Blue, 32 GB)']")
	WebElement brandnameeofseconditem;
	
	@FindBy(xpath="//div[@class = '_3UZZGt' and text() = 'Motorola']")
	WebElement clearbrandfilter;
	
	@FindBy(xpath=".//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]")
	WebElement checknewbrandname;
	
	@FindBy(xpath="//div[@class='_3wU53n' and text() = 'Moto G5s (Lunar Gray, 32 GB)']")
	WebElement selectmobile;
	
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement button;
	
	@FindBy(xpath="//a[@class='_325-ji _3ROAwx' and text() = 'Moto G5s (Lunar Gray, 32 GB)']")
	WebElement cart;
	
	//Initializing the Page Objects 
	
public MobileHomePage () {
		
		PageFactory.initElements(driver, this);		
	}
	
//Actions:

 public void selectRam()
 {
	
	 try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 ram.click();
	 
 }

 public Boolean ValidateItemkDescriptionForRam()
 
 {
	 
	 try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ramsizeoffirstitem.isDisplayed();
	 
 }

public Boolean ValidateItemkDescriptionForRamtwo()
 
 {
	 
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ramsizeofsecondtitem.isDisplayed();
	 
 
 }


public void searchBrand(String brandname) throws InterruptedException

{
	String b = brandname;
	Thread.sleep(3000);
	 
	brandsearchbar.clear();
	brandsearchbar.sendKeys(b);
}

public Boolean validateBrandCheckbox()

{
	
	System.out.println("brand name is " +selectbrand.getText());
	return selectbrand.isDisplayed();
	
	
       	
	
}
public void selectBrand() throws InterruptedException
{
	 

	 Thread.sleep(4000);
	
	selectbrand.click();
	
  

}
 

public String ValidateBrandfilterforfirstitem() throws InterruptedException

{
	 Thread.sleep(2000);
	
     System.out.println("Brand Name of 1st Item" +brandnameeoffirstitem.getText());	
     return brandnameeoffirstitem.getText(); 
}


public String ValidateBrandfilterforsecondtitem()

{
	 
     System.out.println("Brand Name of 2nd Item " +brandnameeofseconditem.getText());	
	 return brandnameeofseconditem.getText();
	
	 
}

public void clearBrandFilter()
{

	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	clearbrandfilter.click();
	
}

public String checkBrandNameAfterRemovingFilter() throws InterruptedException

{
	 Thread.sleep(2000);
	return checknewbrandname.getText();
  
}

public String checkMobileDescription() throws InterruptedException

{

	
     Thread.sleep(2000);	
     System.out.println("Description :- "  +selectmobile.getText());
     
    
     return selectmobile.getText();
	   
		 
}


public void selectMobile()

{
selectmobile.click();	

}


public String addToCart()throws InterruptedException

{
   	
   	Thread.sleep(2000);
   	
   	  String parentWindow=driver.getWindowHandle();
   	  
         System.out.println("Parent Window Title "+driver.getTitle());

         for(String handle:driver.getWindowHandles())
         {
         System.out.println(handle);
         driver.switchTo().window(handle);

     }
   	
         button.click();
	Thread.sleep(2000);
    
	System.out.println("Cart Value  " +cart.getText());
	return cart.getText();
    
}
}

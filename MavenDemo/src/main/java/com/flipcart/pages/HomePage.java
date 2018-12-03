package com.flipcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipcart.base.FlipcartBase;

public class HomePage extends FlipcartBase {
	
	
	//Page factor =OR:
	
	@FindBy(xpath=".//*[@id='container']/div/header/div[3]/ul/li[1]/span")
    WebElement topmenu;
	
	
	@FindBy(name ="q")
    WebElement searchbar;
	
	@FindBy(xpath = "//a[@href=\"/mobiles/pr?sid=tyy,4io&q=mobile&otracker=categorytree\"]")
	WebElement mb;
	
	//(By.xpath("//a[@href=\"/mobiles/pr?sid=tyy,4io&q=mobile&otracker=categorytree\"]"));
	
	//Initializing the Page Objects 
	
	public HomePage () {
		
		PageFactory.initElements(driver, this);		
	}

	//Actions:
	
	public String validateUserLogin() {
		
		
		return driver.getPageSource();
		
	}
	
	public Boolean vlaidatetopMenu()
	
	{
	
		
		return topmenu.isDisplayed();
		
	}
	
	public String navigateToMobilePage() throws InterruptedException
	{
	
		System.out.println("in Naviagte to moible method");
	
		Thread.sleep(3000);
		
		//element = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div/div[2]/form/div/div[1]/div/input"));
		//element.click();
		//element.sendKeys("nobile" +Keys.ENTER);
		searchbar.sendKeys("mobile"  + Keys.ENTER);
		
		Thread.sleep(3000);
		 return mb.getText();
		
	
	}
	
}

package com.flipcart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipcart.base.FlipcartBase;

public class LoginPage extends FlipcartBase  {
	
	
	//Page factor =OR:
	
	@FindBy(className = "_2zrpKA")
     WebElement username;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement password;
	
	
	
	
	//Initializing the Page Objects 
	
	public LoginPage () {
		
		PageFactory.initElements(driver, this);		
	}
	
	
	
	//Actions:
	
	public String validateLoginPage() {
		
		
		return driver.getTitle();
		
	}
	
	public HomePage login(String un, String pwd)
	{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		username.submit();
		
		return new HomePage();
	}
	
}

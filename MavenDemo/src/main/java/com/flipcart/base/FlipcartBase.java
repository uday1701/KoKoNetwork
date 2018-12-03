package com.flipcart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipcart.util.PageTimeOut;

public class FlipcartBase {

  
	public static WebDriver driver;
	public static Properties prop;
	//public static WebElement element;
	
	
	public FlipcartBase()
  
  {
	  
	  prop = new Properties();
	  
	  try {
		
		  FileInputStream ip = new FileInputStream("C:\\Users\\unevase\\eclipse-workspace\\MavenDemo\\src\\"
		  		+ "main\\java\\com\\flipcart\\config\\config.properties");
		
		prop.load(ip);
	
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }


	public static void initialization()
	
	{
		
		String broserName =  prop.getProperty("browser");
		
		if(broserName.equals("chrome"))
  {  

			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32_old\\chromedriver.exe");		
		
			 driver = new ChromeDriver();
			}
		else if(broserName.equals("chrome"))
			
		{
			System.setProperty("webdriver.geco.driver","C:\\Selenium\\chromedriver_win32_old\\geco.exe");		
			
			 driver = new FirefoxDriver();
			
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PageTimeOut.Page_load_timeout, TimeUnit.SECONDS);
		
	
			
		
		
		
		
		
	}

	
	public void addDelay()
	{
		
		//driver.manage().timeouts().implicitlyWait(PageTimeOut.Implicit_wait, TimeUnit.SECONDS);
		try {
			Thread.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

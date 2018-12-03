package com.flipcart.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.flipcart.base.FlipcartBase;

public class TakeSnapShot extends FlipcartBase {

	
	
	   public void takeScreenShot() throws InterruptedException, IOException
	    
	    {
	   
	    	String snap = null;
	    	
	             File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	
	 
	  
				
	             FileUtils.copyFile(file, new File ("C:\\Users\\unevase\\eclipse-workspace\\MavenDemo\\SnapShot\\ScreenShot.png"));
	  
	             System.out.println("Screen Shot taken");
	    
	    }

	
}

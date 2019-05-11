package vtiger.commonFunctions;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import vtiger.Config.vTigerConfig;

public class functions {
	
	
	 public static String getscreenshot(String testname,WebDriver driver) throws Exception 
     {
		    DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
			Date date=new Date();
			String datestr=format.format(date);
			String filename=vTigerConfig.screenshotfolder+testname+"_"+datestr+".png";
		 
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File(filename));
             return filename;
     }

}

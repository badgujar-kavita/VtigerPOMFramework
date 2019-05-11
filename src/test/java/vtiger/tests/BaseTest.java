package vtiger.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import vtiger.Config.vTigerConfig;

public class BaseTest {
	
	public static ExtentReports report;
	public static ExtentTest logger; 
	public static String extentReport;
	
	public WebDriver driver;
	
	public void createReport()
	{
		if(report==null)
		{
		report=new ExtentReports(vTigerConfig.reportpath);
		}
	}
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", vTigerConfig.chromepath);
		driver=new ChromeDriver();
		driver.get(vTigerConfig.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(vTigerConfig.defaulttimeout, TimeUnit.SECONDS);
	}
	
	public void tierDown()
	{
		driver.close();
		driver.quit();
	}

}

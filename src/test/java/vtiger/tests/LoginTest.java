package vtiger.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import vtiger.Config.vTigerConfig;
import vtiger.Pages.HomePage;
import vtiger.Pages.LoginPage;
import vtiger.commonFunctions.functions;

public class LoginTest extends BaseTest {
	
	
	@BeforeClass(alwaysRun = true)
	public void Start()
	{
		createReport();
		launchApp();
	}
	
	
	@Test(groups = {"regression"})
	public void verifyLoginTitleTC001() throws Exception
	{
		logger=report.startTest("verifyLoginTitleTC001");
		LoginPage lp=new LoginPage(driver,logger);
		boolean val=lp.verifyTitle();
		if(val)
		{
		logger.log(LogStatus.PASS, "Title validated successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Title did not match");
			functions.getscreenshot("verifyLoginTitleTC001", driver);
		}
		Assert.assertEquals(val, true);
		report.endTest(logger);
		report.flush();
	}
	
	@Test(groups = {"regression"})
	public void verifyLoginlogoTC002() throws Exception
	{
		logger=report.startTest("verifyLoginlogoTC002");
		LoginPage lp=new LoginPage(driver,logger);
		boolean val=lp.verifylogo();
		logger.log(LogStatus.PASS, "Logo validated successfully");
		//Assert.assertEquals(val, true);
		if(val)
		{
		logger.log(LogStatus.PASS, "Logo validated successfully");
		}
		else
		{
			
			String filename=functions.getscreenshot("verifyLoginlogoTC002", driver);
			logger.log(LogStatus.FAIL, "Logo not found<span class='test-status label fail'><a href="+filename+">Screenshot</a></span>");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@Test(groups = {"regression"})
	public void verifyLoginInValid_TC03()
	{
		logger=report.startTest("verifyLoginInValid_TC03");
		LoginPage lp=new LoginPage(driver,logger);
		boolean val=lp.inValidlogin("dadaaa", "sadada");
		Assert.assertEquals(val, true);
		logger.log(LogStatus.PASS, "Invalid login validated successfully");
		report.endTest(logger);
		report.flush();
	}
	
	@Test(groups = {"regression","Sanity","Smoke"})
	public void verifyLoginValid_TC04()
	{
		logger=report.startTest("verifyLoginValid_TC04");
		LoginPage lp=new LoginPage(driver,logger);
		HomePage hp=lp.login(vTigerConfig.username, vTigerConfig.pwd);
		boolean val=hp.verifyLogout();
		Assert.assertEquals(val, true);
		hp.ClickLogout();
		boolean val1=lp.verifyTitle();
		logger.log(LogStatus.PASS, "Logout validated successfully");
		Assert.assertEquals(val1, true);
		report.endTest(logger);
		report.flush();
		
	}
	
	
	@AfterClass
	public void closeapp()
	{
		tierDown();
	}

}

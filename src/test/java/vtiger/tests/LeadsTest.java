package vtiger.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vtiger.Config.vTigerConfig;
import vtiger.Pages.CreateLeadPage;
import vtiger.Pages.HomePage;
import vtiger.Pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LeadsTest extends BaseTest  {
	
	private WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void Start()
	{
		createReport();
		launchApp();
	}
	

	@Test(groups = {"regression","Sanity"})
	public void CreateLeadTC005() throws Exception
	{
		logger=report.startTest("CreateLeadTC005");
		LoginPage lp=new LoginPage(driver,logger);
		HomePage hp=lp.login(vTigerConfig.username, vTigerConfig.pwd);
		boolean val=hp.verifyLogout();
		Assert.assertEquals(val, true);
		hp.ClickNewLead();
		CreateLeadPage clp=new CreateLeadPage(driver,logger);
		clp.createLeadWithMandatoryfields();
		logger.log(LogStatus.PASS, "Lead created successfully");		
		report.endTest(logger);
		report.flush();
	}
	@Test(priority = 1)
	public void ConvertCreatedLead(){
		logger=report.startTest("ConvertCreatedLead");
		LoginPage lp=new LoginPage(driver,logger);
		HomePage hp=lp.login(vTigerConfig.username, vTigerConfig.pwd);
		boolean val=hp.verifyLogout();
		Assert.assertEquals(val, true);
		hp.ClickNewLead();
		CreateLeadPage clp=new CreateLeadPage(driver,logger);
		clp.createLeadWithMandatoryfields();
		logger.log(LogStatus.PASS, "Lead created successfully");
		clp.ConvertLead();
		logger.log(LogStatus.PASS, "Lead Converted into Account, contact and opportunity");
		report.endTest(logger);
		report.flush();
	}
	
	@AfterClass
	public void closeapp()
	{
		tierDown();
	}

}

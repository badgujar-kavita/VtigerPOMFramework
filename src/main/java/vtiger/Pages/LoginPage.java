package vtiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {
	
	private WebDriver driver;
	private ExtentTest logger; 
	
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	By imgLogo=By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	By txtusername=By.name("user_name");
	By txtpwd=By.name("user_password");
	By btnLogin=By.name("Login");
	By errMsgLogin=By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
	
	
	
	
	public HomePage login(String userid, String pwd)
	{
		driver.findElement(txtusername).clear();
		logger.log(LogStatus.INFO, "Username Textbox cleared");
		driver.findElement(txtusername).sendKeys(userid);
		logger.log(LogStatus.PASS, userid+" entered into username textbox");
		driver.findElement(txtpwd).clear();
		logger.log(LogStatus.INFO, "Password Textbox cleared");
		driver.findElement(txtpwd).sendKeys(pwd);
		logger.log(LogStatus.PASS, pwd+" entered into password textbox");
		driver.findElement(btnLogin).click();	
		logger.log(LogStatus.PASS, "Login button clicked");
		return new HomePage(driver);
	}
	
	
	public boolean inValidlogin(String userid, String pwd)
	{
		driver.findElement(txtusername).clear();
		logger.log(LogStatus.INFO, "Username Textbox cleared");
		driver.findElement(txtusername).sendKeys(userid);
		logger.log(LogStatus.PASS, userid+" entered into username textbox");
		driver.findElement(txtpwd).clear();
		logger.log(LogStatus.INFO, "Password Textbox cleared");
		driver.findElement(txtpwd).sendKeys(pwd);
		logger.log(LogStatus.PASS, pwd+" entered into password textbox");
		driver.findElement(btnLogin).click();	
		logger.log(LogStatus.PASS, "Login button clicked");
		if(driver.findElements(errMsgLogin).size()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean verifylogo()
	{
		if(driver.findElements(imgLogo).size()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean verifyTitle()
	{
		if(driver.getTitle().trim().equals("vtiger CRM - Commercial Open Source CRM"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	

}

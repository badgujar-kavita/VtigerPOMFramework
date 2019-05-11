package vtiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateLeadPage {
	
	private WebDriver driver;
	private ExtentTest logger; 
	
	
	public CreateLeadPage(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	By txtlastname=By.name("lastname");
	By txtcompany=By.name("company");
	By btnsave=By.xpath("//input[@value='  Save  ']");
	By btnconvert = By.xpath("//input[@name='Convert']");
	By txtoppname = By.xpath("//input[@name='potential_name']");
	By txtclosedate = By.id("jscal_field");
	
	public void createLeadWithMandatoryfields()
	{
		driver.findElement(txtlastname).sendKeys("Modi");
		logger.log(LogStatus.PASS, "Modi entered into lastname textbox");
		driver.findElement(txtcompany).sendKeys("BJP");
		logger.log(LogStatus.PASS, "BJP entered into lastname textbox");
		driver.findElement(txtcompany).sendKeys(Keys.ENTER);
	}
	public void ConvertLead(){
		driver.findElement(btnconvert).click();
		driver.findElement(txtoppname).clear();
		driver.findElement(txtoppname).sendKeys("Opportunity created upon conversion");
		driver.findElement(txtclosedate).sendKeys("2019-05-16");
		driver.findElement(btnsave).click();
		
		
	}

}

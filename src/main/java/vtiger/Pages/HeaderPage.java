package vtiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
	
private WebDriver driver;	
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By lnkLogout=By.linkText("Logout");
	By lnkNewLead=By.linkText("New Lead");
	
	
	public boolean verifyLogout()
	{
		if(driver.findElements(lnkLogout).size()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void ClickLogout()
	{
		if(driver.findElements(lnkLogout).size()==1)
		{
			driver.findElement(lnkLogout).click();
		}
		
	}
	
	public void ClickNewLead()
	{
		if(driver.findElements(lnkNewLead).size()==1)
		{
			driver.findElement(lnkNewLead).click();
		}
		
	}
	

}

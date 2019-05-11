package vtiger.Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends HeaderPage {
	

private WebDriver driver;	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean verifyHomePageUrl()
	{
		if(driver.getCurrentUrl().equals("http://localhost:100/index.php?module=Home&action=index"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}

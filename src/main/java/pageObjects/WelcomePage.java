package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class WelcomePage  {

	public WebDriver driver; //Declaring driver object globally within the class

	By creds=By.xpath("//*[text() = 'Internal User']");

	public WelcomePage(WebDriver driver) //Creating Constructor for the LoginPage Class with driver arguments
	{
		this.driver=driver; // making class variable "driver" as constructor driver
	}

	public WebElement getLogin()
	{
		return driver.findElement(creds);
	}

}

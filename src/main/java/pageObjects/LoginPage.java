package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.base;


public class LoginPage extends base {


	//public WebDriver driver; //Declaring driver object globally within the class
	private By user=By.xpath("//input[@id='username']"); //MAKING PRIVATE FOR Encapsulation concept(Secured)
	private By password=By.xpath("//input[@id='password']");
	private By submit=By.xpath("//button[@type='submit']"); 
	private By task=By.xpath("//div[@data-title='Tasks']/child::span[@class='icn icn-tasks'][1]"); //MAKING PRIVATE FOR Encapsulation concept(Secured)
	private By showAllTask=By.xpath("//*[@class='tasks-showall']"); //MAKING PRIVATE FOR Encapsulation concept(Secured)
	//private By selectTask=By.xpath("//a[@title='IQP_GPH_Bedaquiline [ASSMNT-0000002679]'][1]");

	public LoginPage(WebDriver driver) //Creating Constructor for the LoginPage Class with driver arguments
	{
		this.driver=driver; // making class variable "driver" as constructor driver
	}

	public WebElement getUser()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(user);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public WebElement submitButton() {

		return driver.findElement(submit);
	}
	public WebElement clickTaskIcon()
	{
		WebElement ele = driver.findElement(task);
		//		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//		jse.executeScript("arguments[0].click()", ele);
		//MouseHover using JavaScriptExecutor
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript, ele);
		return driver.findElement(task);
	}

	public WebElement showAllTask()    
	{
		return driver.findElement(showAllTask);
	}


}

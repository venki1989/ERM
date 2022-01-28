package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.base;

public class Assessment extends base {
	
	
//	public String variable() throws IOException {
//		
		//properties= new Properties();
//		file= new FileInputStream("C:\\Users\\venkatesh.m\\eclipse-workspace\\ERM\\src\\main\\java\\resources\\data.properties");
		//properties.load(file);
//		String variable=properties.getProperty("AssessmentID");
//		System.out.println(variable);
//		return variable;
//	}
	 
	String variable=properties.getProperty("AssessmentID");
	

	//public String variable = value(); //"ASSMNT-0000003686";
//	public WebDriver driver; //Declaring driver object globally within the class
	private By assessment=By.xpath("//a[contains(@title, \""+variable+"\")]"); //MAKING PRIVATE FOR Encapsulation concept(Secured)
	private By assessmentTitlle=By.xpath("//*[@id='secondary-title']/../div[contains(@title, \""+variable+"\")]");
	private By save=By.xpath("//button[@id='btn-save-custom']");
	private By submitoption=By.xpath("//button[@id='btn-submit']");
	private By cancel=By.xpath("//*[@id='btn-submit-multiaction']/..//a[contains(text(),'Cancel')]");
	private By comments=By.xpath("//textarea[@data-id='ACTION_COMMENTS']");
	private By cancelSubmit=By.xpath("//button[@id='submit']");
	private By cancelSubmitPopup=By.xpath("//button[@id='cancelSubmit']");

	public Assessment(WebDriver driver) //Creating Constructor for the class with driver arguments
	{
		this.driver=driver; // making class variable "driver" as constructor driver
	}


	
	
	
	public WebElement getAssessment()//Method should be created to access the object and public to be accessed to other classes
	{
		
		return driver.findElement(assessment);
	}
	
	public WebElement getAssessmentTitle()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(assessmentTitlle);
	}
	public WebElement getSave()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(save);
	}

	public WebElement getSubmit()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(submitoption);
	}
	public WebElement getCancel()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(cancel);
	}
	
	public WebElement getComments()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(comments);
	}
	public WebElement submitCancel()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(cancelSubmit);
	}
	public WebElement cancelSubmitPopup()//Method should be created to access the object and public to be accessed to other calsses
	{
		return driver.findElement(cancelSubmitPopup);
	}
}

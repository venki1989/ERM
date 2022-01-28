package jNJM7Test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base;
import pageObjects.Assessment;
import pageObjects.LoginPage;
import pageObjects.WelcomePage;

public class OpenAssessment extends base {
	//public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	Assessment assessment;
	WelcomePage m7login;
	LoginPage login;
	WebDriverWait wait;
	//public static Logger log=LogManager.getLogger(base.class.getName());
	//this log code needs to be added in every test in order to trace the logss where ever required

	@Test(dataProvider="getData")
	public void loginDetails(String user, String pass) throws IOException, InterruptedException
	{
		driver=initializeDriver(); // initializeDriver method returns driver from base class
		log.info("Initialized the driver");
		driver.get(properties.getProperty("URL"));
		log.info("opened Url");
		m7login = new WelcomePage(driver); //Getting driver knowledge from login page
		m7login.getLogin().click();
		login = new LoginPage(driver);
		login.getUser().sendKeys(user);
		login.getPassword().sendKeys(pass);
		login.submitButton().click();
		login.clickTaskIcon();
		assessment = new Assessment(driver);
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(assessment.getAssessment()));
		assessment.getAssessment().click();
		//wait.until(ExpectedConditions.textToBePresentInElement(assessment.getAssessmentTitle(), assessment.getAssessmentTitle().getText()));
		String assessmenttitle =assessment.getAssessmentTitle().getText();
		System.out.println(assessmenttitle);
		//Assert.assertEquals(assessmenttitle, "Initial_Approver [ASSMNT-0000002812] ");
		wait.until(ExpectedConditions.elementToBeClickable(assessment.getSave()));
		
		
		if(assessment.getSave().isDisplayed())	
		{
			Assert.assertTrue(true, pass +"is displayed");
			assessment.getSave().click();
			System.out.println("CLICKED");

		}
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[1][2]; // declared based on number of rows and columns
		//First[] is rows, Second [] is column
		//the object array declaration is based on number of values, but the storing/fetching is based on array idex 
		data[0][0]="10020818"; 
		data[0][1]="Welcome@123";

		//		data[1][0]="100005152";
		//		data[1][1]="Welcome@123";

		return data;

	}

	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}



}

package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	public WebDriver driver; //Define as global variable, so that we eliminate for creating object every step, static since we should not change the variable
	public Properties properties; //Define as global variable, so that we eliminate for creating object every step
	public FileInputStream file;

	public WebDriver initializeDriver() throws IOException
	{
		properties= new Properties();
		file= new FileInputStream("C:\\Users\\venkatesh.m\\eclipse-workspace\\ERM\\src\\main\\java\\resources\\data.properties");
		properties.load(file);
		String BrowserName=properties.getProperty("Browser");

		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\venkatesh.m\\Framework\\DRIVER\\geckodriver.exe");
			driver=new FirefoxDriver();

		}
		else if(BrowserName.equals("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();
		return driver; // Return so that any class can use this methods/objects


	}


	public String getScreenshot(String result, WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);  
		String destinationFile=System.getProperty("user.dir")+"\\Reports\\"+result+".png";
		//FileHandler.copy(source,new File("C:\\Users\\venkatesh.m\\Desktop\\FrameworkScreenshot\\"+result+"Screenshot.png"));
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		//Check



	}
}


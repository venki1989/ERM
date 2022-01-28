package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getReortObject()
	{
		String path =System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Result"); //Display info in the report
		reporter.config().setDocumentTitle("Test Result"); //Display info in the report

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("test","dude"); //Display info in the report
		return extent;
	}

}

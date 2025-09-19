package listernersUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import configuration.Baseclass;
public class ListenersImplementation implements ITestListener, ISuiteListener{
//public ExtentTest test;	

	@Override
	public void onStart(ISuite suite) {
		Date d=  new Date();
		String newdate = d.toString().replace(" ", "_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("/.AdavanceReport/report_"+ newdate +".html");
		spark.config().setDocumentTitle("Ninja CRM test suite results");
		spark.config().setReportName("CRM reports");
		spark.config().setTheme(Theme.DARK);
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		//report.setSystemInfo("os", "Window11");
		//report.setSystemInfo("browser","Edge");)
	}

	@Override
	public void onFinish(ISuite suite) {

	}

	@Override
	public void onTestStart(ITestResult result) {
		//test=report.createTest(result.getMethod().getMethodName());
		//test.log(Status.INFO,"==="+result.getMethod().getMethodName()+"Execution Stated\",true");
		//Reporter.log(result.getMethod().getMethodName() +" execution Stated",true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		//test.log(Status.PASS,"==="+result.getMethod().getMethodName() +" execution Stated",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Date d=  new Date();
		String newdate = d.toString().replace(" ", "_").replace(":","_");
		TakesScreenshot ts= (TakesScreenshot)Baseclass.sdriver;
		File  temp = ts.getScreenshotAs(OutputType.FILE);
		String src = ts.getScreenshotAs(OutputType.BASE64);
		//test.addScreenCaptureFromBase64String(src,testname+newdate);
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		//test.log(Status.SKIP,"==="+result.getMethod().getMethodName() +" execution Stated",true);
	}
	



		

}

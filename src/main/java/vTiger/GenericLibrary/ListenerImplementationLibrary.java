package vTiger.GenericLibrary;

import org.testng.ITestListener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.reporters.SuiteHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will Provide Implementation to all the abstract methods in ITestlistener
 * @author Soumya
 *
 */

public class ListenerImplementationLibrary implements ITestListener{
	
	ExtentReports report;
    ExtentTest test;
	
	public void onTestStart(ITestResult result) {
	
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log("test execution started->"+MethodName,true);
		
		test=report.createTest(MethodName); //test script execution is started in report
		test.log(Status.INFO, "Test Execution started");
	}

	
	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		//System.out.println("test is successfull->"+MethodName);
		test.log(Status.PASS, MethodName+" ->pass");
	}

	
	public void onTestFailure(ITestResult result) {
		
		WebDriverLibrary wLib= new WebDriverLibrary();
		JavaLibrary jLib= new JavaLibrary();
		
		String MethodName = result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//System.out.println("Test is failed->"+MethodName);
		test.log(Status.FAIL, "failed");
		test.log(Status.FAIL, result.getThrowable());
		try {
			String path=wLib.takeScreenShot(BaseClass.sDriver, MethodName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();	
		//System.out.println("Test is skipped->"+MethodName);
		test.log(Status.SKIP,MethodName+" ->skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
		
	}

	
	public void onStart(ITestContext context) {
		
		Reporter.log("Execution of suite Started",true);
		
		//Extention of suite starts here, hence configure the extents reports here,Reprt -11-11-2022-10-48.html
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaLibrary(). getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution Reports For vTiger");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vTiger Execution Reports");
		
		//attach the report to extent reports
		 report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser","Chrome");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Platform", "windows");
		report.setSystemInfo("Reopter Name", "Soumya");
		
		
	}

	
	public void onFinish(ITestContext context) {
		
		Reporter.log("Execution of suite finished",true);
		
		//Flush the report - Here the execution is finished.
		
		report.flush();
		
	}
	
	 	 
	  
	 

	
	  
	 }








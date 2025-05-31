package utilities;



import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.internal.annotations.IBeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.Baseclass;

public class Extentreport<screenshot> implements ITestListener


{
	
	public ExtentSparkReporter sprakreport ; // Handle ui of the report 
	
	public ExtentReports extent ; //populate common info on the report 
	
	public ExtentTest test; //create test case entries in report
	
	
	 public  void onStart(ITestContext context) {

	 
		 sprakreport = new ExtentSparkReporter("C:\\SELENIUM\\opencartv1.0.0\\reports\\myreport.html");

		    sprakreport.config().setDocumentTitle("Automation Report");
		    sprakreport.config().setReportName("Test Result");
		    sprakreport.config().setTheme(Theme.DARK);

		    extent = new ExtentReports(); // ✅ this was missing
		    extent.attachReporter(sprakreport); // ✅ now it works

		    extent.setSystemInfo("Tester", "SHRADDHA");
		    extent.setSystemInfo("Environment", "DEV");
		}
	 
	 public void onTestSuccess(ITestResult result) {
		   test =extent.createTest(result.getTestClass().getName()); // "Verfiylogo"
		    
		    test.assignCategory(result.getMethod().getMethodName()); // ✅ This is the correct usage
		    
		    System.out.println(result.getTestClass().getName()+result.getName());
		    
		    test.log(Status.PASS, "Test case passed: " +test); // Also use method name here
		    
		    
		    Object testClassInstance = result.getInstance();
		    WebDriver driver = ((Baseclass) testClassInstance).driver;

		    if (driver instanceof RemoteWebDriver) {
		        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		        String browserName = caps.getBrowserName();
		        String browserVersion = caps.getBrowserVersion();
		        String platform = String.valueOf(caps.getPlatformName());

		        extent.setSystemInfo("Browser", browserName + " " + browserVersion);
		        extent.setSystemInfo("OS", platform);
		        
		    }}
		  public  void onTestFailure(ITestResult result) {
			  String testName = result.getMethod().getMethodName();
			    test = extent.createTest(testName);

			    // Get the actual test class instance where the driver is initialized
			    Object testClassInstance = result.getInstance();
			    WebDriver driver = ((Baseclass) testClassInstance).driver;

			    String screenshotPath = null;

			    if (driver != null) {
			        screenshotPath = ((Baseclass) testClassInstance).screenshot(testName);
			        try {
			            test.addScreenCaptureFromPath(screenshotPath);
			        } catch (Exception e) {
			            e.printStackTrace();
			            test.log(Status.WARNING, "⚠ Failed to attach screenshot: " + e.getMessage());
			        }
			    } else {
			        test.log(Status.WARNING, "⚠ WebDriver was null, screenshot not captured.");
			    }

			    test.log(Status.FAIL, "❌ Test case failed: " + testName);
			    System.out.println("Failed test: " + testName);
			    
			    
			    
		  
		  }

		  public  void onTestSkipped(ITestResult result) {

		  
			  String testName = result.getMethod().getMethodName(); // "Verfiylogo"
			    
			    test = extent.createTest(testName); // ✅ This is the correct usage
			    
			    System.out.println(testName);
			    
			    test.log(Status.SKIP, "Test case skipped: " +testName); 
				
		  }
		


		 
		  
		  public void onFinish(ITestContext context) {
			  
			  extent.flush();
			    // not implemented
			  }
	
	
	
	
	

}

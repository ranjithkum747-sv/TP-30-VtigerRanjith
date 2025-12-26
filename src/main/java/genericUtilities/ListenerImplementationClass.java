package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener,ISuiteListener
{
	ExtentReports report;
	ExtentTest test;

	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		extentTest.set(test);
		extentTest.get().log(Status.INFO, "<b>"+methodName+"--->Execution starts</b>");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		extentTest.get().log(Status.PASS,"<b>"+methodName+"--->PASSED</b>");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{		
		String methodName = result.getMethod().getMethodName();
		String fileName = methodName+new JavaUtils().sysDateTime();
		try
		{
			String filepath = ".\\Screenshot\\"+fileName+".png";
			TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File(filepath);

			FileUtils.copyFile(src, dst);
			String path = dst.getAbsolutePath();
			extentTest.get().addScreenCaptureFromPath(path);//attaching failed SS into the the extent Report
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		extentTest.get().log(Status.FAIL, result.getThrowable());
		extentTest.get().log(Status.FAIL,"<i>"+methodName+"--->FAILED</i>");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		extentTest.get().log(Status.SKIP,"<b>"+methodName+"--->SKIPPED</b>");
	}

	@Override
	public void onStart(ITestContext context)
	{
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\Report"+new JavaUtils().sysDateTime()+".html");
		htmlreport.config().setDocumentTitle("Doc-Title-Name");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("VTiger");

		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "windows");
		report.setSystemInfo("base_url", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Arvind");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		report.flush();
	}

	//	@Override
	//	public void onStart(ISuite suite) {
	//		// TODO Auto-generated method stub
	//		ISuiteListener.super.onStart(suite);
	//	}
	//
	//	@Override
	//	public void onFinish(ISuite suite) {
	//		// TODO Auto-generated method stub
	//		ISuiteListener.super.onFinish(suite);
	//	}	


}

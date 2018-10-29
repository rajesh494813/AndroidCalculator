package util;

import com.relevantcodes.extentreports.*;
import org.apache.commons.io.*;
import java.io.*;
import org.testng.*;
import java.text.*;
import java.util.*;

public class ExtentReporter implements ITestListener
{
    protected static ExtentReports reports;
    protected static ExtentTest test;
    protected static File source;
    
    public void onTestStart(final ITestResult result) {
      
    	(ExtentReporter.test = ExtentReporter.reports.startTest(result.getMethod().getMethodName())).log(LogStatus.INFO, String.valueOf(result.getMethod().getMethodName()) + "is started");
    }
    
    //Over-riding methods to configure Extent Report
    
    public void onTestSuccess(final ITestResult result) {
        ExtentReporter.test.log(LogStatus.PASS, String.valueOf(result.getMethod().getMethodName()) + " is passed");
    }
    
    public void onTestFailure(final ITestResult result) {
        ExtentReporter.test.log(LogStatus.FAIL, String.valueOf(result.getMethod().getMethodName()) + " is failed");
        ScreenshotHelper.TakeScreenshot();
        try {
            final String dest = "./Screenshots/" + result.getMethod().getMethodName() + ".png";
            FileUtils.copyFile(ExtentReporter.source, new File(dest));
            ExtentReporter.test.addBase64ScreenShot(dest);
            ExtentReporter.test.addScreenCapture(dest);
            result.getThrowable().getMessage();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void onTestSkipped(final ITestResult result) {
    }
    
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }
    
    public void onStart(final ITestContext context) {
        ExtentReporter.reports = new ExtentReports("SanityReport" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
    }
    
    public void onFinish(final ITestContext context) {
        ExtentReporter.reports.endTest(ExtentReporter.test);
        ExtentReporter.reports.flush();
    }
}
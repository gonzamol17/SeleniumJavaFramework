package varios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReportNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.aventstack.extentreports.ExtentReports.*;

public class Listeners implements ITestListener {
    static ExtentReports report;
    ExtentTest test;
    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {

      //test = report.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
       // test.log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+"is passed");
        System.out.println("pasó por el success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
       // test.log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+"is failed");
       // test.log(Status.FAIL, result.getThrowable());

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        String actualdate = format.format(date);
        String screenshotPath = System.getProperty("user.dir")+"\\reports\\screenshot\\"+actualdate+".jpg";
        File dest = new File(screenshotPath);
        try {
            FileUtils.copyFile(src, dest);
        }catch (IOException e) {
            e.printStackTrace();
        }
        //test.addScreenCaptureFromPath(screenshotPath,"Test case Failure screenshot");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
       // test.log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+"is skiped");
    }



    @Override
    public void onStart(ITestContext context) {
       // try {
        //    report = ExtentReportNG.setupExtentReport();
      //  }catch (Exception e){e.printStackTrace();}


    }

    @Override
    public void onFinish(ITestContext context) {
       // report.flush();
    }
}

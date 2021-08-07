package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ExtentReportNG {

        static ExtentReports extent;

        public static ExtentReports setupExtentReport() throws Exception{

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            String actualdate = format.format(date);

            String path = System.getProperty("user.dir")+"\\reports\\ExecutionReport"+actualdate+".html";

            ExtentSparkReporter reporter= new ExtentSparkReporter(path);


            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Gonzalo Molina");

            reporter.config().setDocumentTitle("Execution Test");
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setReportName("Web Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            extent.setSystemInfo("Executed on Environment:", System.getProperty("Windows"));


            return extent;

        }
    }


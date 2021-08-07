package varios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import resources.Base;

import java.io.IOException;

//@Listeners(varios.Listeners.class)
public class TestNg_Test extends Base {
    WebDriver driver;
    ExtentTest test;
    ExtentReports extent;


    @BeforeTest
    public void setUp() throws IOException {
       String path1 = System.getProperty("user.dir")+"\\reports\\ExtentReport.html";
       ExtentSparkReporter reporter= new ExtentSparkReporter(path1);

       extent = new ExtentReports();
       extent.attachReporter(reporter);
       extent.setSystemInfo("Tester", "Gonzalo Molina");
       extent.setSystemInfo("Environment", "QA");
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.DARK);


        //String path = System.getProperty("user.dir");
        //System.out.println(path);
        //System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\varios\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver=initializeDriver();

    }

    @Parameters("browserName")
    @Test
    public void abrirWeb1(String browserName) throws InterruptedException {

        System.out.println("Browser Name is :"+browserName);
        test = extent.createTest("Prueba Test 1");
        driver.get(prop.getProperty("url"));

        //driver.get("https://www.selenium.dev/");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#navbar > a:nth-child(5)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#body-inner > div > label:nth-child(4)")).click();
        Thread.sleep(6000);
        test.log(Status.INFO, "Pasó OK INFO");
        test.log(Status.PASS, "Pasó OK pass");




    }

    @Parameters("browserName")
    @Test
    public void abrirWeb2(String browserName) throws InterruptedException {

        System.out.println("Browser Name is :"+browserName);
        test = extent.createTest("Prueba Test 1");
        driver.get(prop.getProperty("url"));

    }

    @AfterTest
    public void tearDownTest(){
        driver.close();
        driver.quit();
        System.out.println("Test Completed");
        extent.flush();
    }
}

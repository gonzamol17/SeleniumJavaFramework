package varios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Base;

public class BrowserTest extends Base {

    public void main(String[] args) {

        //esto es para firefox
        //System.setProperty("Webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\Automation\\Selenium webdriver with java-Basics to Advanced+Frameworks\\SeleniumJavaFramework\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.selenium.dev/");


        //esto es para chrome

            abrirWeb1();
            abrirWeb2();


            //esto es para IE
          /*  String path = System.getProperty("user.dir");
            System.out.println(path);
            System.setProperty("webdriver.ie.driver", path + "\\src\\main\\java\\varios\\IEDriverServer.exe");
            WebDriver driver = new InternetExplorerDriver();
            driver.get("https://www.selenium.dev/");*/

        }
        @Test
        public void abrirWeb1(){


            String path = System.getProperty("user.dir");
            System.out.println(path);
            System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\varios\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.selenium.dev/");
            System.out.println("Estoy dentro del link 1");
            driver.close();
        }

    @Test
    public void abrirWeb2(){

        System.out.println("Test 2");
        Assert.assertTrue(0>1);
    }
}
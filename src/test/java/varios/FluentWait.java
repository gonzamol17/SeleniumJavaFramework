package varios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FluentWait extends Base{

    public void main(String[] args) throws InterruptedException {

        abrirFluent();


     }

        @Test
        public void abrirFluent() throws InterruptedException {

            String path = System.getProperty("user.dir");
            System.out.println(path);
            System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\java\\varios\\chromedriver.exe");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            WebDriver driver = new ChromeDriver(option);
            driver.get("https://www.google.com");
            driver.findElement(By.name("q")).sendKeys("Abcd");
            driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());


           /* Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(30, TimeUnit.SECONDS)
                    .pollingEvery(5, TimeUnit.SECONDS)
                            .ignoring(NoSuchElementException.class);
            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                   public WebElement apply(WebDriver webDriver) {
                    WebElement link = driver.findElement(By.linkText("A.B.C.D. - Sillones | Poufs - Flexform"));
                    if(link.isDisplayed()){
                        System.out.println("Element Found");

                    }
                   return link;
                   }
            });

            element.click();*/



            Thread.sleep(3000);
            driver.close();
            driver.quit();



        }



    }

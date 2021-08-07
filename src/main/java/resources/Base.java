package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;
    public static Logger Log = LogManager.getLogger(Base.class.getName());


    public WebDriver initializeDriver() throws IOException {
        prop= new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\confi.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");
        String urlName=prop.getProperty("url");
        System.out.println(browserName);
        System.out.println(urlName);


        if (browserName.equals("chrome")){

            String pathDriver= System.getProperty("user.dir")+"\\src\\main\\java\\varios\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", pathDriver);
            driver= new ChromeDriver();

        }
        else if(browserName.equals("firefox")){
            String pathDriver= System.getProperty("user.dir")+"\\src\\main\\java\\varios\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", pathDriver);
            driver= new FirefoxDriver();

        }
        else if (browserName.equals("IE")){
            //IE

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
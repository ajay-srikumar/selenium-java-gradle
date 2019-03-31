package framework;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    protected static WebDriver driver;

    public static WebDriver getInstance() throws Exception
    {
        if(Config.get("browser").equalsIgnoreCase("chrome"))
        {
           ChromeOptions co = new ChromeOptions();
            co.addArguments("--kiosk");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver(co);
        }
        else
        {
            System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/src/test/resources/" + Config.get("driver"));

            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

}

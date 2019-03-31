package framework;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;

@Listeners({TestListener.class})
public class BaseTest {

    WebDriver driver = null;

    @BeforeClass(alwaysRun = true)
    public void LaunchApp() throws Throwable {
        initialize();
        clearCookies();
        goToHomePage();
        LoginPage.login(Config.get("username"),Config.get("password"));

    }
    @BeforeMethod(alwaysRun = true)
    public void goHomePage() throws Exception {
        goToHomePage();
    }

   // @AfterMethod(alwaysRun = true)
    public void logout() throws Exception {
        LoginPage.logout();
    }

    @AfterClass(alwaysRun = true)
    public void close() {
        driver.quit();
    }

    public void initialize() throws Exception{
        Config.ReadConfig();
        driver = Driver.getInstance();
    }

    public void clearCookies()
    {
        driver.manage().deleteAllCookies();
    }

    public void goToHomePage() throws Exception
    {
        driver.get(Config.get("appUrl"));
    }

}

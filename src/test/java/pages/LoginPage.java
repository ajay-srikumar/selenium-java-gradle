package pages;

import org.openqa.selenium.By;
import framework.Config;
import framework.WebUi;

public class LoginPage extends WebUi{

    private static By usernameText = By.name("username");
    private static By passwordText = By.name("password");
    private static By loginButton = By.xpath("//input[@type='submit']");
    private static By logoutLink = By.id("logout");

    public static void login(String username, String password) throws Exception{
        findElementWithWait(usernameText,30).clear();
        getElement(usernameText).sendKeys(username);
        getElement(passwordText).sendKeys(password);
        getElement(loginButton).click();
    }


    public static void goToHomePage() throws Exception {
        driver.get(Config.get("baseUrl"));
    }

    public static void logout() throws Exception {

        getElement(logoutLink).click();
    }
}

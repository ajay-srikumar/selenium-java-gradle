package test;

import org.testng.annotations.Test;
import framework.BaseTest;
import pages.*;

public class LoginTest extends BaseTest
{
    @Test(groups = {"smoke"}, priority = 1)
    public void verifyLogin() throws Exception {
        LoginPage.goToHomePage();
        LoginPage.login("username", "password");
        LoginPage.logout();
    }
}

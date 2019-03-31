package framework;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class WebUi extends Driver{

    private static int DEFAULT_WAIT = 10;

    protected static WebElement getElement(By locator) {
        return findElementWithWait(locator, DEFAULT_WAIT);

    }

    protected static WebElement findElementWithWait(By by, int defaultWait) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    protected static WebElement findVisibleElementWithWait(By by, int defaultWait) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    protected static WebElement textNotExist(By by, String text, int defaultWait) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(by,"textContent",text)));
        return driver.findElement(by);
    }



    protected static void waitTillUpdate(int defaultWait) {
        WebDriverWait wait = new WebDriverWait(driver, defaultWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='loading-indicator']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@class='loading-indicator']")));
    }

    protected static void waitFor(Long milli) throws InterruptedException {

        Thread.sleep(milli);

    }

    protected static void open(String url) throws Exception {
        try {
            driver.get(url);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    
    protected static void refreshPage() throws Exception {
        driver.navigate().refresh();
    }

    protected static void type(By by, String testdata) throws Exception {
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(testdata);

    }

    protected static void click(By locator) throws Exception {
            driver.findElement(locator).click();
    }

    protected static void selectDropdownByVisibleName(By by, String item) throws Exception {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(item);
    }
    protected static void selectDropdownByIndex(By by, int index) throws Exception {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }
    protected static void selectDropdownByValue(By by, String value) throws Exception {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }

    protected static boolean isElementPresent(By by){
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public static boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }

    public static void confirmAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

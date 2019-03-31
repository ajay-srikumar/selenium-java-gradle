package framework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    WebDriver driver=null;
    String filePath = System.getProperty("user.dir") + "/build/reports/failureScreenshots/";

   // @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        takeScreenShot(methodName);
        getPageSource(methodName);

    }
    public void onFinish(ITestContext context) {}

    public void onTestStart(ITestResult result) {   }

    public void onTestSuccess(ITestResult result) {   }

  //  @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        takeScreenShot(methodName);
        getPageSource(methodName);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {

    }


    public void getPageSource(String methodName){
        driver = Driver.getDriver();
        File file = new File(filePath+methodName+".html");
        String content = driver.getPageSource();
        try  {
            FileOutputStream fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = content.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShot(String methodName){
        driver = Driver.getDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
            System.out.println("***Placed screen shot in:  file:///"+filePath+ methodName+".png   ***");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

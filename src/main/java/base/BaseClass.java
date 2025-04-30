package base;

import dataprovider.ConfigReader;
import factory.BrowserFactory;
import helper.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("LOG:INFO - Setting Up Browser");

        String browser= ConfigReader.getValue("browser");

        String appurl=ConfigReader.getValue("url");

        driver= BrowserFactory.getDriver(browser,appurl);

        System.out.println("LOG:INFO - Application is up and running");
//        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            Utility.takeScreenShot(driver, result.getName());
        }
//        driver.close();
    }

//    @AfterClass
    public void closeWindow() {
        driver.close();
    }
}

package pages;

import dataprovider.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class Homepage {

    WebDriver driver;

    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Login")
    public WebElement loginLnk;

    @FindBy(linkText = "Employee List")
    public WebElement empDetLnk;

    private By logoff = By.linkText("Log off");



    public void navToLginPage(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = ConfigReader.getValue("url");
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        if (driver.findElements(By.linkText("Log off")).size()>0){
            logoff();
        }else {
            loginLnk.click();
//            driver.navigate().to("http://eaapp.somee.com/Account/Login");
        }
    }

    public void gotoEmpDetPage(){
        empDetLnk.click();
    }

    public void logoff(){
        driver.findElement(logoff).click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "UserName")
    public WebElement usrnamtxt;

    @FindBy(name = "Password")
    private WebElement passTxt;

    @FindBy(css = ".btn")
    private WebElement logInBtn;

    @Test
    public void loginUser(String name, String pass){
        usrnamtxt.sendKeys(name);
        passTxt.sendKeys(pass);
        logInBtn.click();
    }

}

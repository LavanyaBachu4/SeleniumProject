package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EmployeeDetailsPage {

    WebDriver  driver;

    public EmployeeDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a.btn.btn-primary")
    public WebElement createBtn;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Salary")
    public WebElement salary;

    @FindBy(id = "DurationWorked")
    public WebElement durationWorked;

    @FindBy(id = "Grade")
    public WebElement grade;

    @FindBy(id = "Email")
    public WebElement email ;

    @FindBy(className = "btn-default")
    public WebElement createEmp;


    public void createEmp(String empName, String empSalary, String empWorkDuration, String empGrade, String empEmail){
        String val = driver.getCurrentUrl();
        System.out.println("the current page is"+val);

        createBtn.click();
        name.clear();
        name.sendKeys(empName);
        salary.clear();
        salary.sendKeys(empSalary);
        durationWorked.clear();
        durationWorked.sendKeys(empWorkDuration);
        Select selectGrade = new Select(grade);
        selectGrade.selectByVisibleText(empGrade);
        email.click();
        email.sendKeys(empEmail);
        createEmp.click();

        String emailxpath = "//td[contains(text(),'test2@test.com')]";
        boolean emailsearch = driver.findElements(By.xpath(emailxpath)).size() > 0;

        Assert.assertTrue(emailsearch, "The email "+empEmail+" is not present in the table");
    }

}

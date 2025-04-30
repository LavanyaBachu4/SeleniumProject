package com.tc;

import base.BaseClass;
import dataprovider.ConfigReader;
import dataprovider.CustomDataProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeeDetailsPage;
import pages.Homepage;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    Homepage homepg;

    @Test
    public void login(){

//        homepg = PageFactory.initElements(driver, Homepage.class);
        homepg = new Homepage(driver);
        homepg.navToLginPage();
//        LoginPage loginpg = PageFactory.initElements(driver, LoginPage.class);
        LoginPage loginpg = new LoginPage(driver);
        String username = ConfigReader.getValue("ID");
        String pass = ConfigReader.getValue("Pass");
        loginpg.loginUser(username, pass);
        Assert.assertTrue(driver.getTitle().contains("Home - Execute Automation Employee App"), "login failed");
    }

    @Test (dependsOnMethods = {"login"})
    public void crtEmp(){

//        homepg = PageFactory.initElements(driver, Homepage.class);
//        homepg.navToLginPage();
//        LoginPage loginpg = PageFactory.initElements(driver, LoginPage.class);
//        loginpg.loginUser("admin", "password");
        homepg.gotoEmpDetPage();
//        EmployeeDetailsPage empDetPage = PageFactory.initElements(driver, EmployeeDetailsPage.class);
        EmployeeDetailsPage empDetPage = new EmployeeDetailsPage(driver);
        empDetPage.createEmp("test1", "1000", "5", "Senior", "test3@test.com");
    }

//    @Test (dataProvider = "readexcelData", dataProviderClass = CustomDataProvider.class)
    public void loginValidation(String username, String pass){
        homepg = new Homepage(driver);
        homepg.navToLginPage();
        LoginPage loginpg = new LoginPage(driver);
        loginpg.loginUser(username, pass);
        Assert.assertTrue(driver.getTitle().contains("Home - Execute Automation Employee App"), "login failed");
        System.out.println("Page title is " + driver.getTitle());
        if (driver.findElements(By.linkText("Log off")).size()>0){
            homepg.logoff();
        }else {
            driver.navigate().to("http://eaapp.somee.com/Account/Login");
        }
//        Utility.takeScreenShot(driver, username);
        Assert.assertTrue(false);
    }
}

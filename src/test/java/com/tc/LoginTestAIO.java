package com.tc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestAIO {

@Test
public void login(){

    WebDriver driver = new ChromeDriver();

    driver.navigate().to("http://eaapp.somee.com/");

    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.name("UserName")).sendKeys("admin");
    driver.findElement(By.name("Password")).sendKeys("password");
    driver.findElement(By.cssSelector(".btn")).click();

//    driver.close();

}

}

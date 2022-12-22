package com.crm.qa.testcases;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass
{
    public static void main(String[] args)
    {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();

                driver.get("https://classic.freecrm.com/index.html");

        WebElement username=driver.findElement(By.name("username"));
        WebElement password=driver.findElement(By.name("password"));
        username.sendKeys("DeepuShiv");
        password.sendKeys("Test@123");
        WebElement loginBtn =driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        driver.switchTo().frame("mainpanel");
        WebElement UserName =driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]"));

        System.out.println(UserName.getText());
    }



}

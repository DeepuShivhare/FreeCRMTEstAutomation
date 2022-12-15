package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase
{

    WebElement username=driver.findElement(By.name("username"));
    WebElement password=driver.findElement(By.name("password"));
    WebElement loginBtn =driver.findElement(By.xpath("//input[@type='submit']"));

    //WebElement Username =driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]"));

//    public LoginPage()
//    {
//        //super();
//        PageFactory.initElements(driver, this);
//    }
       public String validateLoginPage()
   {
        String str= driver.getTitle();
       System.out.println(str);
        return str;
   }
//    public String validateUser()
//    {
//        String str1=Username.getText();
//        System.out.println(str1);
//        return str1;
//    }

    public HomePage logIn(String un, String psw)
    {
        username.sendKeys(un);
        password.sendKeys(psw);
        loginBtn.click();

        return new HomePage();
    }

}

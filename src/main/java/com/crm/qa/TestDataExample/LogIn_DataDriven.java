package com.crm.qa.TestDataExample;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class LogIn_DataDriven
{
    WebDriver driver;
    public static int sheetNo;

    @BeforeMethod
    public void SetUp()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://classic.freecrm.com/index.html");

        //Extent report
        EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver=e_driver;
    }

// Using Data Provider --- -------
//    @DataProvider
//    public Object[][] getLogInData()
//    {
//        return new Object[][]
//                {
//                        {"Guru99", "India"},
//                        {"Krishna", "UK"},
//                        {"Bhupesh", "USA"}
//                };
//    }

    @DataProvider
    public Object[][] getLogInData()
    {
        Object data[][] =TestUtil.getDataFromSheet(0);
        //System.out.println(data);
        return data;
    }

    @Test(dataProvider= "getLogInData")
    public void LogInTest(String Username, String Password)
    {
        driver.findElement(By.name("username")).sendKeys(Username);;
        driver.findElement(By.name("password")).sendKeys(Password);;

        WebElement loginBtn =driver.findElement(By.xpath("//input[@type='submit']"));

        //loginBtn.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",loginBtn);
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}

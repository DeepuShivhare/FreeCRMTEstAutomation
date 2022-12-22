package com.crm.qa.TestDataExample;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ContactsDataDriven
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

        driver.findElement(By.name("username")).sendKeys("DeepuShiv");
        driver.findElement(By.name("password")).sendKeys("Test@123");

        WebElement loginBtn =driver.findElement(By.xpath("//input[@type='submit']"));

        //loginBtn.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",loginBtn);

        driver.switchTo().frame("mainpanel");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
        Actions action =new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a")).click();

        //Extent report
        EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver=e_driver;

    }

    @DataProvider
    public Object[][] getLogInData()
    {
        Object data[][] = TestUtil.getDataFromSheet(1);
        //System.out.println(data);
        return data;
    }

    @Test(dataProvider= "getLogInData")
    public void NewContactTest(String title, String Firstname, String LastName)
    {

        WebElement Ttl= driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select"));
        Select select=new Select(Ttl);
        select.selectByVisibleText(title);

        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(Firstname);
        driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys(LastName);

        driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")).click();
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}



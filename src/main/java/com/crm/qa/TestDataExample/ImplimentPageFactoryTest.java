package com.crm.qa.TestDataExample;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ImplimentPageFactoryTest
{
    static WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        String url = "https://www.google.com";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 0)
    public void googleSearch()
    {
// Create an object of GoogleHomePage class.
        ImplimentPageFactory gs = new ImplimentPageFactory(driver);
        //gs.title(); // this calls the title method.
        gs.search(); // this calls the search method.
        gs.submit(); // this calls the submit method.
    }
    @AfterTest
    public void closing()
    {
        ImplimentPageFactoryTest.driver.quit();
    }
}
package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest()
    {
        super();
        //PageFactory.initElements(driver, this);
    }
    @BeforeMethod
    public void SetUp()
    {
        initialization();
        loginPage=new LoginPage();
        homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test
    public void verifyHomePageTitleTest()
    {
        String str=homePage.validateHomePageTitle();
        Assert.assertEquals(str, "CRMPRO");
    }



    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}

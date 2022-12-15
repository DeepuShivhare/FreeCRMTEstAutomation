package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginPageTest extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest()
    {
        super();
        //PageFactory.initElements(driver, this);
    }

    @BeforeTest
    public void SetUp()
    {
        initialization();
        loginPage=new LoginPage();
    }

    @Test(priority = 1)
    public void logInTest()
    {
        String uName = "raja";
        String uPwd = "raja";
        homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));

    }
    @Test(priority = 2)


    public void LoginPageTest()
    {
        String s = loginPage.validateLoginPage();
        Assert.assertEquals(s,"CRMPRO");
    }

//   @Test(priority = 3)
//   public void ValidateUserName()
//    {
//        String S1=loginPage.validateUser();
//        Assert.assertEquals(S1, "Deepu Shivhare");
//    }


    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

}

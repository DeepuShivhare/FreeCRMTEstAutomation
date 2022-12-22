package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;
    TestUtils TestUtil;

    ContactsPage contactsPage;

    public HomePageTest()
    {
        super();
    }
    @BeforeMethod
    public void SetUp()
    {
        initialization();
        TestUtil=new TestUtils();
        loginPage=new LoginPage();
        homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
        TestUtil.switchToFrame();

    }
    @Test(priority = 1)
    public void verifyHomePageTitleTest()
    {

        String HomeTitle=homePage.validateHomePageTitle();
        //System.out.println(homePageTitle);
        Assert.assertEquals(HomeTitle, "CRMPRO", "Not matched");
    }

    @Test(priority = 2)
    public void verifyCorrectUserNameTest()
    {
        String user=homePage.verifyCorrectUserName();
        Assert.assertEquals(user, "Deepu Shivhare");

    }
//
//    @Test(priority = 3)
//    public void verifyContactsLinkTest()
//    {
//        TestUtil.switchToFrame();
//        contactsPage = homePage.ClickOnContactsLink();
//
//    }


    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}

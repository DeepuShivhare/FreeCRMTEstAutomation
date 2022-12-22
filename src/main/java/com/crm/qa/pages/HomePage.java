package com.crm.qa.pages;


import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{

    //TestUtils TestUtil=new TestUtils();
    WebElement UserName =driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]"));

//    WebElement UserNameLabel =driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]"));
//
//    WebElement contacts = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
//
//    WebElement deals=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/a"));
//
//    WebElement Tasks=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[6]/a"));


//   public String validateUser()
//    {
//        TestUtil.switchToFrame();
//        String str1=UserNameLabel.getText();
//        System.out.println(str1);
//        return str1;
//    }
    public String validateHomePageTitle()
    {

        return driver.getTitle();

    }
    public String verifyCorrectUserName()
    {
        System.out.println(UserName.getText());

        return UserName.getText();

    }
//    public ContactsPage ClickOnContactsLink()
//    {
//
//        contacts.click();
//        return new ContactsPage();
//    }
//    public DealsPage ClickOnDealsLink()
//    {
//
//        deals.click();
//        return new DealsPage();
//    }
//    public TaskPage ClickOnTasksLink()
//    {
//
//        Tasks.click();
//        return new TaskPage();
//    }


}

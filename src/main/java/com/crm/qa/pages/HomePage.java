package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{
    public HomePage()
    {
        super();
        System.out.println("After login");

        PageFactory.initElements(driver, this);
        
    }

    WebElement UserNameLabel =driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]"));

    WebElement contacts = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));

    WebElement deals=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/a"));

    WebElement Tasks=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[6]/a"));

   public String validateUser()
    {
        String str1=UserNameLabel.getText();
        System.out.println(str1);
        return str1;
    }
    public String validateHomePageTitle()
    {
        return driver.getTitle();

    }
    public ContactsPage ClickOnContactsLink()
    {
        contacts.click();
        return new ContactsPage();
    }
    public DealsPage ClickOnDealsLink()
    {
        deals.click();
        return new DealsPage();
    }
    public TaskPage ClickOnTasksLink()
    {
        Tasks.click();
        return new TaskPage();
    }


}

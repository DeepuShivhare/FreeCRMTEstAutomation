package com.crm.qa.TestDataExample;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ImplimentPageFactory
{
    // WebDriver reference variable.
    WebDriver driver;
    // Pass WebDriver as an input to a the constructor
    public ImplimentPageFactory( WebDriver driver )
    {
        this.driver = driver;
// Call initElements() method by using PageFactory reference and pass driver and this as parameters.
        PageFactory.initElements( driver, this);
    }
    // Locate elements using the required locators
    @FindBy(name= "q")
    WebElement searchBox;
    @FindBy(name = "btnK")
    WebElement submit;

    public void search()
    {
        searchBox.sendKeys("Testing");
    }
    public void submit()
    {
        submit.click();
    }
}
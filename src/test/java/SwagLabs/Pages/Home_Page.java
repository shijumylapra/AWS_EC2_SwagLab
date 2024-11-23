package SwagLabs.Pages;

import SwagLabs.Base_Class;
import SwagLabs.Test_Case.Home_Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Home_Page extends Base_Class {

    @FindBy(id = "item_0_title_link")
    WebElement Item;

    @FindBy(xpath = "//button[text()='ADD TO CART']")
    WebElement button;

    public Home_Page()
    {
        PageFactory.initElements(Base_Class.WDrver, this);
    }

    public void Test_Products(String item1) throws Exception{
        try
        {
            Tsleep();
            Item.click();
            Tsleep();
            button.click();
            Tsleep();
        }
        catch (Exception e) {
            // catching the exception
            System.out.println(e);
        }
    }

}

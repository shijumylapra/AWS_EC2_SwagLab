package SwagLabs.Pages;

import SwagLabs.Base_Class;
import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Login_Page extends Base_Class {
    Alert alert1;
    WebDriver WDriver = Base_Class.WDrver;

    @FindBy(id = "user-name")
    WebElement UserName;
    @FindBy(id = "password")
    WebElement Passwrd;
    @FindBy(id = "login-button")
    WebElement LoginBtn;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement Msg_login_Failure;
    @FindBy(className = "product_label")
    WebElement Msg_login_Success;

    public Login_Page()
    {
        PageFactory.initElements(WDrver, this);
    }
    public void Test_user_login(String Uname, String Pass) {
        UserName.sendKeys(Uname);
        Passwrd.sendKeys(Pass);
        LoginBtn.click();
    }

    public void ValidateErrorMsg(String ExpMsg, boolean message) {
        if (!message) {Assert.assertEquals(ExpMsg, Msg_login_Failure.getText());}
        else {Assert.assertEquals(ExpMsg, Msg_login_Success.getText());}
    }
}

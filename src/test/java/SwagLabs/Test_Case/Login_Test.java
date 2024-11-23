package SwagLabs.Test_Case;

import SwagLabs.Base_Class;
import SwagLabs.Pages.Login_Page;
import org.openqa.selenium.Alert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Test extends Base_Class {

    //Map<String, String> UserName = new HashMap<>();
    Login_Page PC;
    Home_Test HT = new Home_Test();

    @Test(priority = 1, groups = {"products"})
    @Parameters({"ErText2"})
    public void TC02_LoginFailureTest(String EMessage) {
        PC = new Login_Page();
        fetch_data(0, 1);
        PC.Test_user_login(Base_Class.UserValue, Base_Class.PassValue);
        PC.ValidateErrorMsg(EMessage, false);
    }

    @Test(priority = 3, groups = {"products"})
    public void TC01_LoginSuccessTest() throws Exception {
        PC = new Login_Page();
        fetch_data(2, 3);
        PC.Test_user_login(Base_Class.UserValue, Base_Class.PassValue);
        PC.ValidateErrorMsg("Products", true);
        HT.TC01_AddToCartTest();
    }

    @Test(priority = 2, groups = {"products"})
    @Parameters({"ErText1"})
    public void TC03_LockedUserTest(String EMessage) {
        Login_Page PC = new Login_Page();
        fetch_data(4, 5);
        PC.Test_user_login(Base_Class.UserValue, Base_Class.PassValue);
        PC.ValidateErrorMsg(EMessage, false);
    }

}



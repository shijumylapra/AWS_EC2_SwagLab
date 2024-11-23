package SwagLabs.Test_Case;

import SwagLabs.Base_Class;
import SwagLabs.Pages.Home_Page;

public class Home_Test extends Base_Class {

    public void TC01_AddToCartTest() throws Exception {
        HP = new Home_Page();
        HP.Test_Products("");
     }

}

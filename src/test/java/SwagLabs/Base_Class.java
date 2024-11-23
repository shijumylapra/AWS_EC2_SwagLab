package SwagLabs;

import SwagLabs.Pages.Home_Page;
import SwagLabs.Pages.Login_Page;
import SwagLabs.Test_Case.Home_Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Base_Class {
    public static WebDriver WDrver;
    public XSSFWorkbook xbook;
    public XSSFSheet xsheet;
    public static String UserValue, PassValue;
    public static Home_Page HP;
    private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public void SetDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public WebDriver GetDriver() {

        return threadLocalDriver.get();

    }
    // @AfterMethod(alwaysRun = true)
    @BeforeMethod(groups = {"products"})
    public void InitialSetup() throws MalformedURLException {

        String browser = System.getProperty("Browser");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-using") ;
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless") ;
        options.addArguments("--ignore-ssl-errors=yes") ;
        options.addArguments("--ignore-certificate-errors");

        if (browser.equalsIgnoreCase("firefox")) {
            WDrver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("remote-chrome")) {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setPlatform(Platform.LINUX);
            cap.setBrowserName("chrome");

            URL hub = new URL("http://localhost:4444/");
            WDrver = new RemoteWebDriver(hub, cap);
        }
        else {
            WDrver = new ChromeDriver(options);
        }

        SetDriver(WDrver);
        WDrver.get("https://www.saucedemo.com/v1/index.html");
        WDrver.manage().window().maximize();
        WDrver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @AfterMethod(groups = {"products"})
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        WDrver.quit();
    }
    public void Tsleep()throws Exception
    {
        Thread.sleep(1000);
    }
    public void fetch_data(int Uvalue, int PValue) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("UDetail.csv"));
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(splitBy);
                UserValue = employee[Uvalue];
                PassValue = employee[PValue];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
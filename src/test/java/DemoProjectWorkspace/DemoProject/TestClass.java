package DemoProjectWorkspace.DemoProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass
{
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void launchBrowser(@Optional("chrome")String browserName) throws MalformedURLException
    {
        System.out.println("The browser is : " + browserName);

        if(browserName.equalsIgnoreCase("chrome"))
        {
        System.setProperty("webdriver.chrome.driver", "C:\\jba\\tools\\chromedriver_win32_v3.6\\chromedriver.exe");
        driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("grid"))
        {

            DesiredCapabilities cap = DesiredCapabilities.chrome();

            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WIN10);

            String nodeUrl = "http://10.195.108.98:5555/wd/hub";

            driver = new RemoteWebDriver(new URL(nodeUrl), cap);

            System.out.println("Test cases are running on GRID");
        }
    }


    @Test
    public void method1()
    {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.name("userName")).sendKeys("username");
    }

    @Test
    public void method2()
    {
        driver.get("https://google.com");
    }

    @AfterMethod
    public void tearDownMethod()
    {
      driver.close();
    }

}
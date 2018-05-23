package DemoProjectWorkspace.DemoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClass2 {

    WebDriver driver;

    @Test
    public void method1()
    {
        String browser="chrome";
        System.out.println("The browser is : " + browser);

        if(browser.equalsIgnoreCase("chrome"))
        {
        System.setProperty("webdriver.chrome.driver", "C:\\jba\\tools\\chromedriver_win32_v3.6\\chromedriver.exe");
        driver = new ChromeDriver();
        }
        else
        {
            System.out.println("No such browser availabe : " +browser);
        }

        driver.get("https://accenture.com");
    }

    @Test
    public void method2()
    {
        String browser="chrome";
        System.out.println("The browser is : " + browser);

        if(browser.equalsIgnoreCase("chrome"))
        {
        System.setProperty("webdriver.chrome.driver", "C:\\jba\\tools\\chromedriver_win32_v3.6\\chromedriver.exe");
        driver = new ChromeDriver();
        }
        else
        {
            System.out.println("No such browser availabe : " +browser);
        }

        driver.get("https://yahoo.com");
    }

    @AfterMethod
    public void tearDownMethod()
    {
        driver.close();
    }


}

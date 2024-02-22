package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

abstract public class BaseTest {
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless= false;
        Configuration.reportsFolder = "src/test/screenshots";
    }

    @BeforeMethod
    public void init(){
        setUp();
    }

    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}

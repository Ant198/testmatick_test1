package test_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void lounchBroweser() {
        setDriver(new ChromeDriver());
        getDriver().get("https://www.google.com.ua/");
    }

    @AfterMethod
    public void closeBroweser() {

        getDriver().close();
    }
}

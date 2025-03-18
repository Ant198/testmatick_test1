package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private WebDriver driver;


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void lounchBroweser() throws MalformedURLException {
        String remoteUrl = System.getProperty("selenium.remote", "http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        setDriver(new RemoteWebDriver(new URL(remoteUrl), capabilities));
        setDriver(new ChromeDriver());
        getDriver().get("https://www.google.com.ua/");
    }

    @AfterMethod
    public void closeBroweser() {

        getDriver().close();
    }

}

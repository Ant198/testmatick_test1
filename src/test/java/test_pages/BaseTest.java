package test_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    private String baseUrl = "https://www.google.com.ua/";
    private String currentUrl;
    private String expectedText = "Java";
    private String baseTitle;
    private String currentTitle;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setExpectedText (String text){
        this.expectedText = text;
    }

    public String getExpectedText () {
        return expectedText;
    }

    public void setBaseTitle(String text){
        this.baseTitle = text;
    }

    public String getBaseTitle () {
        return baseTitle;
    }

    public void setCurrentTitle(String text){
        this.currentTitle = text;
    }

    public String getCurrentTitle () {
        return currentTitle;
    }

    @BeforeTest
    public void lounchBroweser() {
        setDriver(new ChromeDriver());
        getDriver().get("https://www.google.com.ua/");
    }

    @AfterTest
    public void closeBroweser() {
        getDriver().close();
    }
}
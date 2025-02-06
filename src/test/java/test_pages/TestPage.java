package test_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

import java.time.Duration;

public class TestPage {
    WebDriver driver;
    String baseUrl = "https://www.google.com.ua/";
    String currentUrl;
    String expectedText = "Java";
    String baseTitle;
    String currentTitle;

    @BeforeTest
    public void lounchBroweser() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
    }

    @AfterTest
    public void closeBroweser() {
        driver.close();
    }

    @Test
    public void isRightLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        SearchPage searchPage = new SearchPage(driver);
        currentUrl = searchPage.getCurrentUrl();
        baseTitle = searchPage.getPageTitle();
        searchPage.typeText();
        searchPage.clickButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        ResultPage resultPage = new ResultPage(driver);
        currentTitle = resultPage.getPageTitle();

        for (WebElement header : resultPage.getListOfText()) {
            Assert.assertTrue(header.getText().contains("Java"), "error");
        }
        Assert.assertEquals(baseUrl, currentUrl, "wrong url");
        Assert.assertEquals(expectedText.toString(), searchPage.getTypedText(), "wrong text");
        Assert.assertFalse(baseTitle.equals(resultPage.getPageTitle()), "page did not load");

    }
}
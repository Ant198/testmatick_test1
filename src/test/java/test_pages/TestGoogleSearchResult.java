package test_pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

import java.time.Duration;

public class TestGoogleSearchResult extends BaseTest {
    String baseUrl = "https://www.google.com.ua/";
    String currentUrl;
    String expectedText = "Java";
    String baseTitle;
    String currentTitle;

    @Test
    public void isTestGoogleSearchResult() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        SearchPage searchPage = new SearchPage(getDriver());
        currentUrl = searchPage.getCurrentUrl();
        baseTitle = searchPage.getPageTitle();
        searchPage.typeText();
        searchPage.clickButton();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        ResultPage resultPage = new ResultPage(getDriver());
        currentTitle = resultPage.getPageTitle();

        for (WebElement header : resultPage.getListOfText()) {
            Assert.assertTrue(header.getText().contains("Java"), "error");
        }
        Assert.assertEquals(baseUrl, currentUrl, "wrong url");
        Assert.assertEquals(expectedText, searchPage.getTypedText(), "wrong text");
        Assert.assertFalse(baseTitle.equals(resultPage.getPageTitle()), "page did not load");
    }
}
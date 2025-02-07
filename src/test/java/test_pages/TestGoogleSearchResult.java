package test_pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

import java.time.Duration;

public class TestGoogleSearchResult extends BaseTest {

    @Test
    public void isTestGoogleSearchResult() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        SearchPage searchPage = new SearchPage(getDriver());
        setCurrentUrl(searchPage.getCurrentUrl());
        setBaseTitle(searchPage.getPageTitle());
        searchPage.typeText();
        searchPage.clickButton();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        ResultPage resultPage = new ResultPage(getDriver());
        setCurrentTitle(resultPage.getPageTitle());

        for (WebElement header : resultPage.getListOfText()) {
            Assert.assertTrue(header.getText().contains("Java"), "error");
        }
        Assert.assertEquals(getBaseUrl(), getCurrentUrl(), "wrong url");
        Assert.assertEquals(getExpectedText(), searchPage.getTypedText(), "wrong text");
        Assert.assertFalse(getBaseTitle().equals(resultPage.getPageTitle()), "page did not load");
    }
}
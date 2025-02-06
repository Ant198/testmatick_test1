import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

abstract  class BasePage {
    WebDriver driver;
    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    };
}

class SearchPage extends BasePage {
    By searchField = By.xpath("//textArea[@class='gLFyf']");
    By searchButton = By.xpath("//input");

    SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void typeText() {
        driver.findElement(searchField).sendKeys("Java");
    }

    public String getTypedText() {
        return driver.findElement(searchField).getDomProperty("value");
    }

    public void clickButton() {
        driver.findElement(searchButton).click();
    }
}

class ResultPage extends BasePage {
    By headers = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']");

    ResultPage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> getListOfText() {
        return driver.findElements(headers);
    }

}

public class SearchTest {
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
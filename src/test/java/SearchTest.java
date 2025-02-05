import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SearchTest {
    String baseUrl = "https://www.google.com.ua/";
    String currentUrl;
    CharSequence inputText = "java";
    String currentInputText;
    String baseTitle;
    String currentTitle;
    WebDriver driver;
    WebElement element;
    WebElement button;
    List<WebElement> headers;

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
        currentUrl = driver.getCurrentUrl();
        element = driver.findElement(By.xpath("//textArea[@class='gLFyf']"));
        element.sendKeys(inputText );
        currentInputText = element.getDomProperty("value");
        baseTitle = driver.getTitle();
        button = driver.findElement(By.xpath("//input"));
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        currentTitle = driver.getTitle();
        headers = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));

        for (WebElement header : headers) {
            Assert.assertTrue(header.getText().contains("Java"), "error");
        }
        Assert.assertEquals(baseUrl, currentUrl, "wrong url");
        Assert.assertEquals(inputText.toString(), currentInputText, "wrong text");
        Assert.assertFalse(baseTitle.equals(currentTitle), "page did not load");

    }
}
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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


    void openPage() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        currentUrl = driver.getCurrentUrl();
    }

    void inputText() {
        element = driver.findElement(By.xpath("//textArea[@class='gLFyf']"));
        element.sendKeys(inputText );
        currentInputText = element.getDomProperty("value");
    }

    void clickButton() {
        baseTitle = driver.getTitle();
        button = driver.findElement(By.xpath("//input"));
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        currentTitle = driver.getTitle();
    }

    @Test
    public void isRightLink() {
        openPage();
        Assert.assertEquals(baseUrl, currentUrl, "wrong url");
        inputText();
        Assert.assertEquals(inputText.toString(), currentInputText, "wrong text");
        clickButton();
        Assert.assertFalse(baseTitle.equals(currentTitle), "page did not load");
    }
}
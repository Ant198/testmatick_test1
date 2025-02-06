package pages;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    By searchField = By.xpath("//textArea[@class='gLFyf']");
    By searchButton = By.xpath("//input");

    public SearchPage(WebDriver driver) {
        super(driver);

    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void typeText() {
        getDriver().findElement(searchField).sendKeys("Java");
    }

    public String getTypedText() {
        return getDriver().findElement(searchField).getDomProperty("value");
    }

    public void clickButton() {
        getDriver().findElement(searchButton).click();
    }
}
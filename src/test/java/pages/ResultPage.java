package pages;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage extends BasePage {
    By headers = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfText() {
        return getDriver().findElements(headers);
    }

}
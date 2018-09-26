package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    private static String TITLE = "Amazon.com: best sellers in digital cameras";
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openDetailsNthProduct(final Integer productNumber) {
        WebElement element = driver.findElement(By.id("result_" + productNumber));
        element.findElement(By.className("a-link-normal")).click();
    }
}

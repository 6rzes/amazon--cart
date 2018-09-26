package navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavigationPane {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(id = "nav-cart")
    private WebElement cart;

    public NavigationPane(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchPhrease(final String searchPhrase) {
        searchField.sendKeys(searchPhrase);
    }

    public void clickOnNthResult(final Integer elementNumber) {
        WebElement nthResult = driver.findElement(By.id("issDiv" + elementNumber));
        nthResult.click();
    }

    public void goToCart() {
        cart.click();
    }
}

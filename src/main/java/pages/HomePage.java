package pages;

import navigation.NavigationPane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    private static final String HOME_PAGE_URL = "http://www.amazon.com";

    private final NavigationPane navigationPane;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationPane = new NavigationPane(driver);
    }

    public void goTo() {
        driver.get(HOME_PAGE_URL);
    }

    public NavigationPane naviagationPane() {
        return navigationPane;
    }

}
